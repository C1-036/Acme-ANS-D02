
package acme.entities.flights;

import java.beans.Transient;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.ValidMoment;
import acme.client.components.validation.ValidString;
import acme.constraints.ValidFlightNumber;
import acme.constraints.ValidLeg;
import acme.entities.airports.Airport;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@ValidFlightNumber
@ValidLeg
public class Leg extends AbstractEntity {

	// Serialisation version --------------------------------------------------
	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------
	@Mandatory
	@ValidString(pattern = "^[A-Z]{2,3}\\d{4}$")
	@Column(unique = true)
	@Automapped
	private String				flightNumber;

	@Mandatory
	@Temporal(TemporalType.TIMESTAMP)
	@ValidMoment
	@Automapped
	private Date				scheduledDeparture;

	@Mandatory
	@Temporal(TemporalType.TIMESTAMP)
	@ValidMoment
	@Automapped
	private Date				scheduledArrival;

	@Mandatory
	@Valid
	@Automapped
	private LegStatus			status;

	@Mandatory
	@ValidString(min = 1, max = 50)
	@Automapped
	private String				aircraft;

	// Derived attributes -----------------------------------------------------


	@Transient
	public Double getDurationHours() {
		if (this.scheduledDeparture == null || this.scheduledArrival == null)
			return null;
		long millis = this.scheduledArrival.getTime() - this.scheduledDeparture.getTime();
		return millis / (1000.0 * 60 * 60);
	}

	// Relationships ----------------------------------------------------------


	@Mandatory
	@Valid
	@ManyToOne(optional = false)

	private Airport	departureAirport;

	@Mandatory
	@Valid
	@ManyToOne(optional = false)

	private Airport	arrivalAirport;

	// @Mandatory
	// @Valid
	// @ManyToOne(optional = false)
	// private Aircraft aircraft;

	@Mandatory
	@Valid
	@ManyToOne(optional = false)
	private Flight	flight;

}
