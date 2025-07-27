package com.algaworks.algadelivery.delivery.tracking.domen.model;

import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.time.Duration;
import org.junit.jupiter.api.Test;

import com.algaworks.algadelivery.delivery.tracking.domain.model.ContactPoint;
import com.algaworks.algadelivery.delivery.tracking.domain.model.Delivery;
import com.algaworks.algadelivery.delivery.tracking.domain.model.DeliveryStatus;
import com.algaworks.algadelivery.delivery.tracking.domain.model.Delivery.PreparationDetails;
import com.algaworks.algadelivery.delivery.tracking.domain.model.excption.DomainExcetion;

class DeliveryTest {

	@Test
	public void shouldToPlaced() {
		
		Delivery delivery = Delivery.draft();		
		delivery.editPreparationDetails(createdValidPreparationDetails());
		delivery.place();
		assertEquals(DeliveryStatus.WAITING_FOR_COURIER, delivery.getStatus());
		assertNotNull(delivery.getPlacedAt());
		
	}
	
	@Test
	public void shouldNotToPlaced() {
		
		Delivery delivery = Delivery.draft();
		assertThrows(DomainExcetion.class, () -> {
			delivery.place();
		});
		
		assertEquals(DeliveryStatus.DRAFT, delivery.getStatus());
		assertNull(delivery.getPlacedAt());
		
	}

	private PreparationDetails createdValidPreparationDetails() {
		
		ContactPoint sender = ContactPoint.builder()
				.zipCode("12365-987")
				.street("Rua Brasil")
				.number("522")
				.complement("100")
				.name("João Silva")
				.phone("(11) 92154-9648")
				.build();
		
		ContactPoint recipient = ContactPoint.builder()
				.zipCode("00000-000")
				.street("Rua São Paulo")
				.number("100")
				.complement("")
				.name("Maria Alves")
				.phone("(11) 92154-6548")
				.build();
		
		return Delivery.PreparationDetails.builder()
				.sender(sender)
				.recipient(recipient)
				.distanceFee(new BigDecimal("15.00"))
				.courierPayout(new BigDecimal("5.00"))
				.expectedDeliveryTime(Duration.ofHours(5))
				.build();
	}
}
