package com.onecode.exception;


/**
 * @author :One_Code
 */
public class ErrorCode {

	private ErrorCode() {
	}

	public static class Common {
		private Common() {
		}

		public static final String ID_MUST_NOT_NULL = "id.is.null";
	}

	public static class VehicleBrand {
		private VehicleBrand() {
		}

		public static final String VEHICLE_BRAND_NOT_EXIST = "vehicle.brand.not.exist";
		public static final String VEHICLE_BRAND_EXIST = "vehicle.brand.exist";
		public static final String VEHICLE_LIST_NOT_FOUND = "vehicle.list.not.found";
		public static final String VEHICLE_BRAND_IS_EMPTY = "vehicle.brand.empty";
	}
	public static class VehicleType{
		private VehicleType() {
		}
		public static final String VEHICLE_TYPE_NOT_EXIST ="vehicle.type.not.exist";
		public static final String VEHICLE_TYPE_EXIST ="vehicle.type.exist";
		public static final String VEHICLE_TYPE_LIST_NOT_FOUND = "vehicle.type.list.not.exist";
		public static final String VEHICLE_TYPE_IS_EMPTY = "vehicle.type.empty";

	}

	public static class VehicleModel{

		private VehicleModel() {
		}

		public static final String VEHICLE_MODEL_NOT_EXIST ="vehicle.model.not.exist";
		public static final String VEHICLE_MODEL_EXIST ="vehicle.model.exist";
		public static final String VEHICLE_MODEL_LIST_NOT_FOUND = "vehicle.model.list.not.exist";
		public static final String VEHICLE_MODEL_IS_EMPTY = "vehicle.model.empty";

	}

	public static class Vehicle{
		private Vehicle() {
		}

		public static final String VEHICLE_NOT_EXIST ="vehicle.not.exist";
		public static final String VEHICLE_ALREADY_EXIST ="vehicle.already.exist";
		public static final String VEHICLE_LIST_NOT_FOUND = "vehicle.list.not.exist";
		public static final String VEHICLE_IS_EMPTY = "vehicle.is.empty";
		public static final String VEHICLE_NUMBER_IS_EMPTY = "vehicle.number.is.empty";

	}
}