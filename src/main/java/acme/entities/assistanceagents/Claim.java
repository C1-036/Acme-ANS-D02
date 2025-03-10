
package acme.entities.assistanceagents;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.validation.Valid;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.ValidEmail;
import acme.client.components.validation.ValidMoment;
import acme.client.components.validation.ValidString;
import acme.realms.AssistanceAgents;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Claim extends AbstractEntity {

	private static final long	serialVersionUID	= 1L;

	//Atributos ------------------------------------
	@Mandatory
	@ValidMoment(past = true)
	@Automapped
	private Date				registrationMoment;

	@Mandatory
	@Automapped
	@ValidEmail
	private String				passengerEmail;

	@Mandatory
	@Automapped
	@ValidString(max = 255)
	private String				description;

	@Mandatory
	@Automapped
	@Enumerated(EnumType.STRING)
	@Valid
	private ClaimType			type;

	@Mandatory
	@Automapped
	private boolean				accepted;

	// Relationships ----------------------------------------------------------
	@Mandatory
	@Valid
	@ManyToOne(optional = false)
	@Automapped
	private AssistanceAgents	assistanceAgent;

}
