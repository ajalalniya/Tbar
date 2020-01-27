package co.tara.tarabari.passenger.utils.parameters;

/**
 * Created by SedAliReza on 5/6/2017.
 */
public interface ParameterID {

    /*PARENT*/
    public final long SERVER_SETTING = 1;
    public final long PASSENGER_SETTING = 2;
    public final long DRIVER_SETTING = 3;
    public final long COMPANY_SETTING = 4;
    public final long PASSENGER_MSG = 5;
    public final long DRIVER_MSG = 6;
    public final long COMPANY_MSG = 7;
    public final long VEHICLE_TYPE = 8;
    public final long TRIP_TYPE = 9;
    public final long LOAD_TYPE = 10;
    public final long TRIP_PAYMENT_TYPE = 11;
    public final long TRANSACTION_TYPE = 12;
    public final long PASSENGER_STATE = 13;
    public final long DRIVER_STATE = 14;
    public final long VEHICLE_STATE = 15;
    public final long ACCOUNT_STATE = 16;
    public final long TRIP_STATE = 17;
    public final long ACTIVE_VEHICLE_STATE = 18;


    /*SERVER_SETTING*/
    public final long LNG_DISTANCE_SOURCE = 101;
    public final long LAT_DISTANCE_SOURCE = 102;
    public final long SELECT_TOP_COUNT_VEHICLE_FOR_TRIP = 103;
    public final long BASE_FEE = 104;
    public final long EXTEND_FEE_SCALE = 105;


    /*PASSENGER_SETTING*/
    public final long TIME_THREAD_REQUEST_DRIVER_LAT_LNG = 131;
    public final long PASSENGER_APP_VERSION = 130;

/*DRIVER_SETTING*/
    public final long DRIVER_APP_VERSION =150 ;
    public final long SEND_LAT_LNG_IN_TRIP =151 ;
    public final long SEND_LAT_LNG_WITHOUT_TRIP = 152;



/*VEHICLE_TYPR*/
    public final long TAXI =170;
    public final long PAYK =171;
    public final long VANET =172;
    public final long KAMIUNET =173;

    /*TRIP_TYPE*/
    public final long NORMAL_TRIP = 180;
    public final long VIP =181 ;



    /*LOAD_TYPE*/
    public final long NORMAL_LOAD=190 ;
    public final long SHEKASTANI =191 ;
    public final long FASED_SHODANI =192 ;

    /*PAYMENT_TYPE*/
    public final long CACH_PAY_IN_SOURCE =200 ;
    public final long  CREDIT_PAY=201 ;
    public final long CACH_PAY_IN_DESTINATION =202 ;

    /*TRANSACTION_TYPE*/
    public final long INCREASE_CREDIT =210 ;
    public final long CREDIT_PAY_TRIP=211 ;
    public final long GIFT_PAY =212 ;
    public final long CREDIT_RECEIPT_TRIP = 213;
    public final long CACH_PAY_TRIP =214 ;
    public final long CACH_RECEIPT_TRIP = 215;


/*ACCOUNT_STATE*/
    public final long NEW_ACCOUNT=230 ;
    public final long ENABLE =231 ;
    public final long BLOCK =232 ;
    public final long REMOVE =233 ;
    public final long DISABLE =234 ;


/*ACTIVE_VEHICLE_STATE*/
    public final long ACTIVE =240 ;
    public final long IN_TRIP =241 ;

    /*TRIP_STATE*/
    public final long NEW_TRIP =250 ;
    public final long ACCEPT_DRIVER =251 ;
    public final long WAIT_FOR_COMING_DRIVER=252 ;
    public final long COMING_DRIVER =253 ;
    public final long LOADING =254 ;
    public final long START_TRIP =255 ;
    public final long DELIVERED_LOAD =256 ;
    public final long END_TRIP =257 ;
    public final long PASSENGER_CANCEL_TRIP =258 ;
    public final long DRIVER_CANCEL_TRIP =259 ;
    public final long PROBLEM_TRIP =260 ;


}
