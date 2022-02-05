package com.at.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Type {
	private TypeName type;
	private int slot;

}
