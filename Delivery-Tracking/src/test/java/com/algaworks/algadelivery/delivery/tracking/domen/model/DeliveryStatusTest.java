package com.algaworks.algadelivery.delivery.tracking.domen.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.algaworks.algadelivery.delivery.tracking.domain.model.DeliveryStatus;

class DeliveryStatusTest {

	@Test
	void draftCanChangeToWaitingForCourier() {
		assertTrue(DeliveryStatus.DRAFT.canChangeTo(DeliveryStatus.WAITING_FOR_COURIER));
	}

	@Test
	void draftCanChangeToInTransit() {
		assertTrue(DeliveryStatus.DRAFT.canNotChangeTo(DeliveryStatus.IN_TRANSIT));
	}
}
