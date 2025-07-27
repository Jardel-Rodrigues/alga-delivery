package com.algaworks.algadelivery.courier.management.domain.model;

import java.time.OffsetDateTime;
import java.util.UUID;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@EqualsAndHashCode
@Setter(value = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class AssignedDelivery {

	@EqualsAndHashCode.Include
	private UUID id;
	
	private OffsetDateTime assigendAt;
	
	static AssignedDelivery pending(UUID deliveryId) {
		var delivery = new AssignedDelivery();
		delivery.setId(deliveryId);
		delivery.setAssigendAt(OffsetDateTime.now());
		return delivery;
	}
}
