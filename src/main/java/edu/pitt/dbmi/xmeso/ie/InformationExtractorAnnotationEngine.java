package edu.pitt.dbmi.xmeso.ie;

import java.util.Iterator;
import java.util.TreeSet;

import org.apache.commons.lang3.StringUtils;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;

import edu.pitt.dbmi.xmeso.model.Model.EndOfDocument;
import edu.pitt.dbmi.xmeso.model.Model.Part;
import edu.pitt.dbmi.xmeso.model.Model.Section;
import edu.pitt.dbmi.xmeso.model.Model.XmesoCaseForm;
import edu.pitt.dbmi.xmeso.model.Model.XmesoLymphNodesExamined;
import edu.pitt.dbmi.xmeso.model.Model.XmesoNamedEntity;
import edu.pitt.dbmi.xmeso.model.Model.XmesoSize;
import edu.pitt.dbmi.xmeso.model.Model.XmesoSpecialStain;
import edu.pitt.dbmi.xmeso.model.Model.XmesoSurgicalProcedure;
import edu.pitt.dbmi.xmeso.model.Model.XmesoTumorForm;
import edu.pitt.dbmi.xmeso.model.Model.XmesoUltrastructuralFindings;

public class InformationExtractorAnnotationEngine extends
		org.apache.uima.fit.component.JCasAnnotator_ImplBase {

	private final TreeSet<Integer> partNumbers = new TreeSet<Integer>();
	private final TreeSet<Integer> sectionLevels = new TreeSet<Integer>();
	private final TreeSet<Integer> codedPenalties = new TreeSet<Integer>();

	private int currentPart = -1;
	private int currentSectionLevel = -1;
	private int currentCodedPenalty = -1;

	private EndOfDocument endOfDocument;

	private XmesoCaseForm defaultCaseForm;
	private XmesoCaseForm currentCaseForm;

	private XmesoTumorForm defaultTumorForm;
	private XmesoTumorForm currentTumorForm;

	private int reportNumber = 0;

	public static void main(String[] args) {
		InformationExtractorAnnotationEngine ie = new InformationExtractorAnnotationEngine();
		String result = ie.extractSuffixTerm("\\NMVB\\MESOTHELIOMA\\ANATOMICAL PATHOLOGY\\SITE OF TUMOR\\PERICARDIUM\\");
//		System.out.println("The result is " + result);
	}

	@Override
	public void process(JCas jCas) throws AnalysisEngineProcessException {
//		System.out.println("InformationExtractor Processing report "
//				+ reportNumber++);
		clearCaches();
		ftrXchangePartToNamedEntity(jCas);
		cacheEndOfDocument(jCas);
		initalizeSizeCodePenalties(jCas);
		initializeDefaultCaseForm(jCas);
		initializeDefaultTumorForm(jCas);
		gatherSectionLevels(jCas);
		gatherPartLevels(jCas);
		gatherCodePenalties(jCas);
		fillCaseForm(jCas);
		fillTumorForms(jCas);
	}

	private void clearCaches() {
		partNumbers.clear();
		sectionLevels.clear();
		codedPenalties.clear();
	}

	private void ftrXchangePartToNamedEntity(JCas jCas) {
		for (Part part : JCasUtil.select(jCas, Part.class)) {
			for (XmesoNamedEntity namedEntity : JCasUtil.selectCovered(XmesoNamedEntity.class, part)) {
				namedEntity.setPartNumber(part.getPartNumber());
				namedEntity.setSectionName(part.getSectionName());
				namedEntity.setSectionLevel(part.getSectionLevel());
				namedEntity.addToIndexes(jCas);
			}
		}
	}

	private void cacheEndOfDocument(JCas jCas) {
		endOfDocument = JCasUtil.select(jCas, EndOfDocument.class).iterator().next();
	}

	private void initalizeSizeCodePenalties(JCas jCas) {
		for (XmesoSize xmesoSize : JCasUtil.select(jCas, XmesoSize.class)) {
			xmesoSize.setCodedPenalty(1);
		}
	}

	private void initializeDefaultCaseForm(JCas jCas) {
		defaultCaseForm = new XmesoCaseForm(jCas);
		defaultCaseForm.setSurgicalProcedure("PROC|DX:UN");
		defaultCaseForm.setUltrastructuralFindings("ANA|ULTRASTRUCTURAL:UN");
		defaultCaseForm.setLymphNodesExamined("PATH|LYMPH_EXAMINED:NO");
		defaultCaseForm.setSpecialStain("PATH|SPECIAL_STAIN:UN");

		defaultCaseForm.setSurgicalProcedureTerm("Unknown");
		defaultCaseForm.setUltrastructuralFindingsTerm("Unknown");
		defaultCaseForm.setLymphNodesExaminedTerm("No");
		defaultCaseForm.setSpecialStainTerm("Unknown");

		defaultCaseForm.setBegin(endOfDocument.getBegin());
		defaultCaseForm.setEnd(endOfDocument.getEnd());
	}

	private void initializeCurrentCaseForm(JCas jCas) {
		currentCaseForm = new XmesoCaseForm(jCas);
		currentCaseForm.setSurgicalProcedure(defaultCaseForm.getSurgicalProcedure());
		currentCaseForm.setUltrastructuralFindings(defaultCaseForm.getUltrastructuralFindings());
		currentCaseForm.setLymphNodesExamined(defaultCaseForm.getLymphNodesExamined());
		currentCaseForm.setSpecialStain(defaultCaseForm.getSpecialStain());

		currentCaseForm.setSurgicalProcedureTerm(defaultCaseForm.getSurgicalProcedureTerm());
		currentCaseForm.setUltrastructuralFindingsTerm(defaultCaseForm.getUltrastructuralFindingsTerm());
		currentCaseForm.setLymphNodesExaminedTerm(defaultCaseForm.getLymphNodesExaminedTerm());
		currentCaseForm.setSpecialStainTerm(defaultCaseForm.getSpecialStainTerm());

		currentCaseForm.setBegin(defaultCaseForm.getBegin());
		currentCaseForm.setEnd(defaultCaseForm.getEnd());
	}

	private void initializeDefaultTumorForm(JCas jCas) {
		defaultTumorForm = new XmesoTumorForm(jCas);
		defaultTumorForm.setCurrentPart(-1);
		defaultTumorForm.setHistopathologicalType("HIST_TYPE:UNKNOWN");
		defaultTumorForm.setTumorSite("TUMOR_SITE:UNKNOWN");
		defaultTumorForm.setTumorConfiguration("SNOMED:399740008");
		defaultTumorForm.setTumorDifferentiation("ANA|TUMOR_DIFF:NA");
		defaultTumorForm.setHistopathologicalTypeTerm("Unknown");
		defaultTumorForm.setTumorSiteTerm("Unknown");
		defaultTumorForm.setTumorConfigurationTerm("Unknown");
		defaultTumorForm.setTumorDifferentiationTerm("Unknown");
		defaultTumorForm.setSizeDimensionX(-1.0f);
		defaultTumorForm.setSizeDimensionY(-1.0f);
		defaultTumorForm.setSizeDimensionZ(-1.0f);
		defaultTumorForm.setSizeDimensionMax(-1.0f);
		defaultTumorForm.setBegin(endOfDocument.getBegin());
		defaultTumorForm.setEnd(endOfDocument.getEnd());
	}

	private void initializeCurrentTumorForm(JCas jCas) {
		currentTumorForm = new XmesoTumorForm(jCas);

		currentTumorForm.setCurrentPart(currentPart);
		currentTumorForm.setHistopathologicalType(defaultTumorForm.getHistopathologicalType());
		currentTumorForm.setTumorSite(defaultTumorForm.getTumorSite());
		currentTumorForm.setTumorConfiguration(defaultTumorForm.getTumorConfiguration());
		currentTumorForm.setTumorDifferentiation(defaultTumorForm.getTumorDifferentiation());

		currentTumorForm.setHistopathologicalTypeTerm(defaultTumorForm.getHistopathologicalTypeTerm());
		currentTumorForm.setTumorSiteTerm(defaultTumorForm.getTumorSiteTerm());
		currentTumorForm.setTumorConfigurationTerm(defaultTumorForm.getTumorConfigurationTerm());
		currentTumorForm.setTumorDifferentiationTerm(defaultTumorForm.getTumorDifferentiationTerm());

		currentTumorForm.setBegin(defaultTumorForm.getBegin());
		currentTumorForm.setEnd(defaultTumorForm.getEnd());
	}

	private void gatherSectionLevels(JCas jCas) {
		for (Section section : JCasUtil.select(jCas, Section.class)) {
			int sectionLevel = section.getLevel();
			sectionLevels.add(sectionLevel);
		}
	}

	private void gatherPartLevels(JCas jCas) {
		for (Part part : JCasUtil.select(jCas, Part.class)) {
			int partNumber = part.getPartNumber();
			partNumbers.add(partNumber);
		}
	}

	private void gatherCodePenalties(JCas jCas) {
		for (XmesoNamedEntity namedEntity : JCasUtil.select(jCas,
				XmesoNamedEntity.class)) {
			int codedPenalty = namedEntity.getCodedPenalty();
			codedPenalties.add(codedPenalty);
		}
	}

	private void fillCaseForm(JCas jCas) {
		initializeCurrentCaseForm(jCas);
		for (Iterator<Integer> sectionLevelIterator = sectionLevels.iterator(); sectionLevelIterator.hasNext();) {
			currentSectionLevel = sectionLevelIterator.next();
			for (Iterator<Integer> codedPenaltyIterator = codedPenalties.iterator(); codedPenaltyIterator.hasNext();) {
				currentCodedPenalty = codedPenaltyIterator.next();
				fillCaseFormAtLevels(jCas, currentCaseForm, currentSectionLevel, currentCodedPenalty);
			}
		}
		jCas.addFsToIndexes(currentCaseForm);
	}

	private void fillCaseFormAtLevels(JCas jCas, XmesoCaseForm currentCaseForm,
			int currentSectionLevel, int currentCodedPenalty) {
		for (Section section : JCasUtil.select(jCas, Section.class)) {
			for (XmesoNamedEntity namedEntity : JCasUtil.selectCovered(
					XmesoNamedEntity.class, section)) {
				boolean isCurrent = true;
				isCurrent = isCurrent
						&& (section.getLevel() == currentSectionLevel);
				isCurrent = isCurrent
						&& (namedEntity.getCodedPenalty() == currentCodedPenalty);
				isCurrent = isCurrent && !namedEntity.getIsNegated();
				if (isCurrent) {
					String simpleClassName = namedEntity.getClass()
							.getSimpleName();
					if (XmesoSurgicalProcedure.class.getSimpleName().equals(simpleClassName)) {
						if (currentCaseForm.getSurgicalProcedure().equals(defaultCaseForm.getSurgicalProcedure())) {
							currentCaseForm.setSurgicalProcedure(namedEntity.getSnomedCode());
							currentCaseForm.setSurgicalProcedureTerm(extractSuffixTerm(namedEntity.getI2b2OntologyPath()));
						}
					}
					else if (XmesoUltrastructuralFindings.class.getSimpleName().equals(simpleClassName)) {
						if (currentCaseForm.getUltrastructuralFindings().equals(defaultCaseForm.getUltrastructuralFindings())) {
							currentCaseForm.setUltrastructuralFindings(namedEntity.getSnomedCode());
							String suffixTerm = extractSuffixTerm(namedEntity.getI2b2OntologyPath());
							currentCaseForm.setUltrastructuralFindingsTerm(suffixTerm);
						}
					}
					else if (XmesoLymphNodesExamined.class.getSimpleName().equals(simpleClassName)) {
						if (currentCaseForm.getLymphNodesExamined().equals(defaultCaseForm.getLymphNodesExamined())) {
							currentCaseForm.setLymphNodesExamined(namedEntity.getSnomedCode());
							currentCaseForm.setLymphNodesExaminedTerm(extractSuffixTerm(namedEntity.getI2b2OntologyPath()));
						}
					}
					else if (XmesoSpecialStain.class.getSimpleName().equals(simpleClassName)) {
						if (currentCaseForm.getSpecialStain().equals(defaultCaseForm.getSpecialStain())) {
							currentCaseForm.setSpecialStain(namedEntity.getSnomedCode());
							currentCaseForm.setSpecialStainTerm(extractSuffixTerm(namedEntity.getI2b2OntologyPath()));
						}
					}
				}
			}
		}
	}

	private void fillTumorForms(JCas jCas) {
		for (Iterator<Integer> partNumberIterator = partNumbers.iterator(); partNumberIterator
				.hasNext();) {
			currentPart = partNumberIterator.next();
			initializeCurrentTumorForm(jCas);
			for (Iterator<Integer> sectionLevelIterator = sectionLevels.iterator(); sectionLevelIterator.hasNext();) {
				currentSectionLevel = sectionLevelIterator.next();
				for (Iterator<Integer> codedPenaltyIterator = codedPenalties.iterator(); codedPenaltyIterator.hasNext();) {
					currentCodedPenalty = codedPenaltyIterator.next();
					fillTumorFormRemainingSlots(jCas);
				}
			}
			jCas.addFsToIndexes(currentTumorForm);
		}
	}

	private void fillTumorFormRemainingSlots(JCas jCas) {
		for (Section section : JCasUtil.select(jCas, Section.class)) {
			for (Part part : JCasUtil.selectCovered(Part.class, section)) {
				for (XmesoNamedEntity namedEntity : JCasUtil.selectCovered(XmesoNamedEntity.class, part)) {
					boolean isCurrent = true;
					isCurrent = isCurrent
							&& (section.getLevel() == currentSectionLevel);
					isCurrent = isCurrent
							&& (part.getPartNumber() == currentPart);
					isCurrent = isCurrent
							&& (namedEntity.getCodedPenalty() == currentCodedPenalty);
					isCurrent = isCurrent && !namedEntity.getIsNegated();
					if (isCurrent) {
						String simpleClassName = namedEntity.getClass()
								.getSimpleName();
						if ("XmesoHistologicalType".equals(simpleClassName)) {
							if (defaultTumorForm.getHistopathologicalType()
									.equals(currentTumorForm
											.getHistopathologicalType())) {
								currentTumorForm
										.setHistopathologicalType(namedEntity
												.getSnomedCode());
								currentTumorForm
										.setHistopathologicalTypeTerm(extractSuffixTerm(namedEntity
												.getI2b2OntologyPath()));
							}
						} else if ("XmesoTumorSite".equals(simpleClassName)) {
							if (defaultTumorForm.getTumorSite().equals(
									currentTumorForm.getTumorSite())) {
								currentTumorForm.setTumorSite(namedEntity
										.getSnomedCode());
								currentTumorForm
										.setTumorSiteTerm(extractSuffixTerm(namedEntity
												.getI2b2OntologyPath()));
							}
						} else if ("XmesoTumorConfiguration"
								.equals(simpleClassName)) {
							if (defaultTumorForm.getTumorConfiguration()
									.equals(currentTumorForm
											.getTumorConfiguration())) {
								currentTumorForm
										.setTumorConfiguration(namedEntity
												.getSnomedCode());
								currentTumorForm
										.setTumorConfigurationTerm(extractSuffixTerm(namedEntity
												.getI2b2OntologyPath()));
							}
						} else if ("XmesoTumorDifferentiation"
								.equals(simpleClassName)) {
							if (defaultTumorForm.getTumorDifferentiation()
									.equals(currentTumorForm
											.getTumorDifferentiation())) {
								currentTumorForm
										.setTumorDifferentiation(namedEntity
												.getSnomedCode());
								currentTumorForm
										.setTumorDifferentiationTerm(extractSuffixTerm(namedEntity
												.getI2b2OntologyPath()));
							}
						} else if ("XmesoSize".equals(simpleClassName)) {
							XmesoSize currentSize = (XmesoSize) namedEntity;
							if (currentSize.getMaxDim() > currentTumorForm
									.getSizeDimensionMax()) {
								currentTumorForm.setSizeDimensionX(currentSize
										.getDimOne());
								currentTumorForm.setSizeDimensionY(currentSize
										.getDimTwo());
								currentTumorForm.setSizeDimensionZ(currentSize
										.getDimThree());
								currentTumorForm
										.setSizeDimensionMax(currentSize
												.getMaxDim());
							}
						}
					}
				}
			}
		}
	}

	private String extractSuffixTerm(String i2b2OntologyPath) {
		String backSlash = "\\";
		return StringUtils.substringAfterLast(
				StringUtils.substringBeforeLast(i2b2OntologyPath, backSlash),
				backSlash);
	}

}
