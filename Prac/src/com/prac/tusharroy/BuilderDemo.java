package com.prac.tusharroy;

/**
 * @author Manish Karki
 * 
 */

public class BuilderDemo {
	// required parameters
	private String param1;
	private String param2;

	// optional parameters
	private boolean bool1;
	private boolean bool2;

	public BuilderDemo(Builder builder) {
		this.param1 = builder.param1;
		this.param2 = builder.param2;
		this.bool1 = builder.bool1;
		this.bool2 = builder.bool2;
	}

	public String getParam1() {
		return param1;
	}

	public String getParam2() {
		return param2;
	}

	public boolean isBool1() {
		return bool1;
	}

	public boolean isBool2() {
		return bool2;
	}
	
	public String toString(){
		return this.getParam1()+" "+getParam2();
	}

	public static class Builder {

		// required parameters
		private String param1;
		private String param2;

		// optional parameters
		private boolean bool1;
		private boolean bool2;

		public Builder(String param1, String param2) {
			this.param1 = param1;
			this.param2 = param2;
		}

		
		public Builder setGraphicsCardEnabled(boolean bool1) {
			this.bool1 = bool1;
			return this;
		}

		public Builder setBluetoothEnabled(boolean bool2) {
			this.bool2 = bool2;
			return this;
		}
		
		public BuilderDemo build(){
			return new BuilderDemo(this);
		}

	}

}
