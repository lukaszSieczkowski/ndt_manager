package pl.ndt.manager.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import pl.ndt.manager.model.enums.TypeOfTesting;

@Entity
@Table(name="probes")
@PrimaryKeyJoinColumn(name = "device_id")
public class Probe extends Device {
	
	@Column(name="frequency")
	private Double frequency;
	@Column(name="angle")
	private Integer angle;
	@Column(name="type_of_testing")
	private TypeOfTesting typeOfTesting;
	
	public Probe() {
		super();
	}

	public Probe(Long id, String name, String producer, Integer productionYear, String model, String serialNumber,
			LocalDateTime startOfUse, Location location,Double frequency,Integer angle,TypeOfTesting typeOfTesting) {
		super(id, name, producer, productionYear, model, serialNumber, startOfUse, location);
		this.frequency = frequency;
		this.angle = angle;
		this.typeOfTesting = typeOfTesting;
	}

	public Double getFrequency() {
		return frequency;
	}

	public void setFrequency(Double frequency) {
		this.frequency = frequency;
	}

	public Integer getAngle() {
		return angle;
	}

	public void setAngle(Integer angle) {
		this.angle = angle;
	}

	public TypeOfTesting getTypeOfTesting() {
		return typeOfTesting;
	}

	public void setTypeOfTesting(TypeOfTesting typeOfTesting) {
		this.typeOfTesting = typeOfTesting;
	}

	@Override
	public String toString() {
		return "Probe [frequency=" + frequency + ", angle=" + angle + ", typeOfTesting=" + typeOfTesting + ", id=" + id
				+ ", name=" + name + ", producer=" + producer + ", productionYear=" + productionYear + ", model="
				+ model + ", serialNumber=" + serialNumber + ", startOfUse=" + startOfUse + ", location=" + location
				+ "]";
	}

	


	
	
}