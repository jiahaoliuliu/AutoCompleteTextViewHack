package com.jiahaoliuliu.autocompletetextviewhack.model;

public class Cinema {

    // The unique Id of the cinema
    private int cinemaID;

    // The name of the cinema
    private String cinemaName;

    // The complete address of the cinema
    private String cinemaCompleteAddress;

    // The empty constructor
    public Cinema(){}

	public Cinema(int cinemaID, String cinemaName,
			String cinemaCompleteAddress) {
		super();
		this.cinemaID = cinemaID;
		this.cinemaName = cinemaName;
		this.cinemaCompleteAddress = cinemaCompleteAddress;
	}

	public int getCinemaID() {
		return cinemaID;
	}

	public void setCinemaID(int cinemaID) {
		this.cinemaID = cinemaID;
	}

	public String getCinemaName() {
		return cinemaName;
	}

	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}

	public String getCinemaCompleteAddress() {
		return cinemaCompleteAddress;
	}

	public void setCinemaCompleteAddress(String cinemaCompleteAddress) {
		this.cinemaCompleteAddress = cinemaCompleteAddress;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((cinemaCompleteAddress == null) ? 0 : cinemaCompleteAddress
						.hashCode());
		result = prime * result + cinemaID;
		result = prime * result
				+ ((cinemaName == null) ? 0 : cinemaName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cinema other = (Cinema) obj;
		if (cinemaCompleteAddress == null) {
			if (other.cinemaCompleteAddress != null)
				return false;
		} else if (!cinemaCompleteAddress.equals(other.cinemaCompleteAddress))
			return false;
		if (cinemaID != other.cinemaID)
			return false;
		if (cinemaName == null) {
			if (other.cinemaName != null)
				return false;
		} else if (!cinemaName.equals(other.cinemaName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return getCinemaName();
	}

}
