package com.laptrinhjavaweb.buider;

public class BuildingSearch {
	
	private String name;
	private String dictrict;
	private String numberofbasement;
	private String floorArea;
	private String rentAreaFrom;
	private String rentAreaTo;
	
	public BuildingSearch(Buider builder) {
		this.name = builder.name;
		this.dictrict = builder.dictrict;
		this.numberofbasement = builder.numberofbasement;
		this.floorArea = builder.floorArea;
		this.rentAreaFrom = builder.rentAreaFrom;
		this.rentAreaTo = builder.rentAreaTo;
	}
	
	public String getName() {
		return name;
	}

	public String getDictrict() {
		return dictrict;
	}

	public String getNumberofbasement() {
		return numberofbasement;
	}
	
	public String getFloorArea() {
		return floorArea;
	}
	
	public String getRentAreaFrom() {
		return rentAreaFrom;
	}

	public String getRentAreaTo() {
		return rentAreaTo;
	}



	public static class Buider {
		private String name;
		private String dictrict;
		private String numberofbasement;
		private String floorArea;
		private String rentAreaFrom;
		private String rentAreaTo;
		
		public Buider setName(String name) {
			this.name = name;
			return this;
		}
		public Buider setDictrict(String dictrict) {
			this.dictrict = dictrict;
			return this;
		}
		public Buider setNumberofbasement(String numberofbasement) {
			this.numberofbasement = numberofbasement;
			return this;
		}
		public Buider setFloorArea(String floorArea) {
			this.floorArea = floorArea;
			return this;
		}
		
		public Buider setRentAreaFrom(String rentAreaFrom) {
			this.rentAreaFrom = rentAreaFrom;
			return this;
		}
		public Buider setRentAreaTo(String rentAreaTo) {
			this.rentAreaTo = rentAreaTo;
			return this;
		}
		
		public BuildingSearch build() {
			return new BuildingSearch(this);
		}
	}
}
