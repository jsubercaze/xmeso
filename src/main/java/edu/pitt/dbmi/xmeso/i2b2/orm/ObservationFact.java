package edu.pitt.dbmi.xmeso.i2b2.orm;

// Generated Apr 15, 2015 4:30:25 PM by Hibernate Tools hbm2java 4.3.1
// Modified Aug 10, 2016 by Zhou Yuan

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "XMESO_OBSERVATION_FACT")
public class ObservationFact implements Serializable {

	private static final long serialVersionUID = 1L;

	private ObservationFactId id;
	private String valtypeCd;
	private String tvalChar;
	private BigDecimal nvalNum;
	private String valueflagCd;
	private BigDecimal quantityNum;
	private String unitsCd;
	private Date endDate;
	private String locationCd;
	private String observationBlob;
	private BigDecimal confidenceNum;
	private Date updateDate;
	private Date downloadDate;
	private Date importDate;
	private String sourcesystemCd;
	private BigDecimal uploadId;

	public ObservationFact() {
	}

	public ObservationFact(ObservationFactId id) {
		this.id = id;
	}

	public ObservationFact(
			ObservationFactId id, 
			String valtypeCd,
			String tvalChar, 
			BigDecimal nvalNum, 
			String valueflagCd,
			BigDecimal quantityNum, 
			String unitsCd, 
			Date endDate,
			String locationCd, 
			String observationBlob, 
			BigDecimal confidenceNum,
			Date updateDate, 
			Date downloadDate, 
			Date importDate,
			String sourcesystemCd, 
			BigDecimal uploadId) {
		this.id = id;
		this.valtypeCd = valtypeCd;
		this.tvalChar = tvalChar;
		this.nvalNum = nvalNum;
		this.valueflagCd = valueflagCd;
		this.quantityNum = quantityNum;
		this.unitsCd = unitsCd;
		this.endDate = endDate;
		this.locationCd = locationCd;
		this.observationBlob = observationBlob;
		this.confidenceNum = confidenceNum;
		this.updateDate = updateDate;
		this.downloadDate = downloadDate;
		this.importDate = importDate;
		this.sourcesystemCd = sourcesystemCd;
		this.uploadId = uploadId;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "patientNum", column = @Column(name = "PATIENT_NUM", nullable = false, precision = 38, scale = 0)),
			@AttributeOverride(name = "conceptCd", column = @Column(name = "CONCEPT_CD", nullable = false, length = 50)),
			@AttributeOverride(name = "modifierCd", column = @Column(name = "MODIFIER_CD", nullable = false, length = 100)),
			@AttributeOverride(name = "startDate", column = @Column(name = "START_DATE", nullable = false, length = 7)),
			@AttributeOverride(name = "encounterNum", column = @Column(name = "ENCOUNTER_NUM", nullable = false, precision = 38, scale = 0)),
			@AttributeOverride(name = "instanceNum", column = @Column(name = "INSTANCE_NUM", nullable = false, precision = 18, scale = 0)),
			@AttributeOverride(name = "providerId", column = @Column(name = "PROVIDER_ID", nullable = false, length = 50)) })
	public ObservationFactId getId() {
		return this.id;
	}

	public void setId(ObservationFactId id) {
		this.id = id;
	}

	@Column(name = "VALTYPE_CD", length = 50)
	public String getValtypeCd() {
		return this.valtypeCd;
	}

	public void setValtypeCd(String valtypeCd) {
		this.valtypeCd = valtypeCd;
	}

	@Column(name = "TVAL_CHAR")
	public String getTvalChar() {
		return this.tvalChar;
	}

	public void setTvalChar(String tvalChar) {
		this.tvalChar = tvalChar;
	}

	@Column(name = "NVAL_NUM", precision = 18, scale = 5)
	public BigDecimal getNvalNum() {
		return this.nvalNum;
	}

	public void setNvalNum(BigDecimal nvalNum) {
		this.nvalNum = nvalNum;
	}

	@Column(name = "VALUEFLAG_CD", length = 50)
	public String getValueflagCd() {
		return this.valueflagCd;
	}

	public void setValueflagCd(String valueflagCd) {
		this.valueflagCd = valueflagCd;
	}

	@Column(name = "QUANTITY_NUM", precision = 18, scale = 5)
	public BigDecimal getQuantityNum() {
		return this.quantityNum;
	}

	public void setQuantityNum(BigDecimal quantityNum) {
		this.quantityNum = quantityNum;
	}

	@Column(name = "UNITS_CD", length = 50)
	public String getUnitsCd() {
		return this.unitsCd;
	}

	public void setUnitsCd(String unitsCd) {
		this.unitsCd = unitsCd;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "END_DATE", length = 7)
	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Column(name = "LOCATION_CD", length = 50)
	public String getLocationCd() {
		return this.locationCd;
	}

	public void setLocationCd(String locationCd) {
		this.locationCd = locationCd;
	}

	@Lob
	@Column(name = "OBSERVATION_BLOB")
	public String getObservationBlob() {
		return this.observationBlob;
	}

	public void setObservationBlob(String observationBlob) {
		this.observationBlob = observationBlob;
	}

	@Column(name = "CONFIDENCE_NUM", precision = 18, scale = 5)
	public BigDecimal getConfidenceNum() {
		return this.confidenceNum;
	}

	public void setConfidenceNum(BigDecimal confidenceNum) {
		this.confidenceNum = confidenceNum;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATE_DATE", length = 7)
	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DOWNLOAD_DATE", length = 7)
	public Date getDownloadDate() {
		return this.downloadDate;
	}

	public void setDownloadDate(Date downloadDate) {
		this.downloadDate = downloadDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "IMPORT_DATE", length = 7)
	public Date getImportDate() {
		return this.importDate;
	}

	public void setImportDate(Date importDate) {
		this.importDate = importDate;
	}

	@Column(name = "SOURCESYSTEM_CD", length = 50)
	public String getSourcesystemCd() {
		return this.sourcesystemCd;
	}

	public void setSourcesystemCd(String sourcesystemCd) {
		this.sourcesystemCd = sourcesystemCd;
	}

	@Column(name = "UPLOAD_ID", precision = 38, scale = 0)
	public BigDecimal getUploadId() {
		return this.uploadId;
	}

	public void setUploadId(BigDecimal uploadId) {
		this.uploadId = uploadId;
	}

}
