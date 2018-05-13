package com.shama.model;

import lombok.Data;

import java.util.Date;


@Data
public class Price {
	private String product_code; // код товара
	private int number; // номер цены
	private int depart; // номер отдела
	private Date begin; // начало действия
	private Date end; // конец действия
	private long value; // значение цены в копейках

	public Price(String product_code, int number, int depart, Date begin, Date end, long value) {
		this.product_code = product_code;
		this.number = number;
		this.depart = depart;
		this.begin = begin;
		this.end = end;
		this.value = value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Price price = (Price) o;

		if (number != price.number) return false;
		if (depart != price.depart) return false;
		if (value != price.value) return false;
		if (!product_code.equals(price.product_code)) return false;
		if (!begin.equals(price.begin)) return false;
		return end.equals(price.end);
	}

	@Override
	public int hashCode() {
		int result = product_code.hashCode();
		result = 31 * result + number;
		result = 31 * result + depart;
		result = 31 * result + begin.hashCode();
		result = 31 * result + end.hashCode();
		result = 31 * result + (int) (value ^ (value >>> 32));
		return result;
	}
}
