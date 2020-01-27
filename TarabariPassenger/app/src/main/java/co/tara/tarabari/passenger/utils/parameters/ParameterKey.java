package co.tara.tarabari.passenger.utils.parameters;

/**
 * Created by SedAliReza on 5/6/2017.
 */
public interface ParameterKey {
    /*PARENT*/
    public final long SERVER_SETTING = 101;
    public final long PASSENGER_SETTING = 102;
    public final long DRIVER_SETTING = 103;
    public final long COMPANY_SETTING = 104;
    public final long PASSENGER_MSG = 105;
    public final long DRIVER_MSG = 106;
    public final long COMPANY_MSG = 107;
    public final long VEHICLE_TYPE = 108;
    public final long TRIP_TYPE = 109;
    public final long LOAD_TYPE = 110;
    public final long TRIP_PAYMENT_TYPE = 111;
    public final long TRANSACTION_TYPE = 112;
    public final long PASSENGER_STATE = 113;
    public final long DRIVER_STATE = 114;
    public final long VEHICLE_STATE = 115;
    public final long ACCOUNT_STATE = 116;
    public final long TRIP_STATE = 117;
    public final long ACTIVE_VEHICLE_STATE = 118;


    /*SERVER_SETTING*/
    public final long LNG_DISTANCE_SOURCE = 101101;
    public final long LAT_DISTANCE_SOURCE = 101102;
    public final long SELECT_TOP_COUNT_VEHICLE_FOR_TRIP =101103;
    public final long BASE_FEE = 101104;
    public final long EXTEND_FEE_SCALE = 101105;


    /*PASSENGER_SETTING*/
    public final long TIME_THREAD_REQUEST_DRIVER_LAT_LNG = 102131;
    public final long PASSENGER_APP_VERSION = 102130;

    /*DRIVER_SETTING*/
    public final long DRIVER_APP_VERSION =103150 ;
    public final long SEND_LAT_LNG_IN_TRIP =103151 ;
    public final long SEND_LAT_LNG_WITHOUT_TRIP = 103152;



    /*VEHICLE_TYPR*/
    public final long TAXI =108170;
    public final long PAYK =108171;
    public final long VANET =108172;
    public final long KAMIUNET =108173;

    /*TRIP_TYPE*/
    public final long NORMAL_TRIP = 109180;
    public final long VIP =109181 ;



    /*LOAD_TYPE*/
    public final long NORMAL_LOAD=110190 ;
    public final long SHEKASTANI =110191 ;
    public final long FASED_SHODANI =110192 ;

    /*PAYMENT_TYPE*/
    public final long CACH_PAY_IN_SOURCE =111200 ;
    public final long  CREDIT_PAY=111201 ;
    public final long CACH_PAY_IN_DESTINATION =111202 ;

    /*TRANSACTION_TYPE*/
    public final long INCREASE_CREDIT =112210 ;
    public final long CREDIT_PAY_TRIP=112211 ;
    public final long GIFT_PAY =112212 ;
    public final long CREDIT_RECEIPT_TRIP = 112213;
    public final long CACH_PAY_TRIP =112214 ;
    public final long CACH_RECEIPT_TRIP = 112215;


    /*ACCOUNT_STATE*/
    public final long NEW_ACCOUNT=116230 ;
    public final long ENABLE =116231 ;
    public final long BLOCK =116232 ;
    public final long REMOVE =116233 ;
    public final long DISABLE =116234 ;


    /*ACTIVE_VEHICLE_STATE*/
    public final long ACTIVE =118240 ;
    public final long IN_TRIP =118241 ;

    /*TRIP_STATE*/
    public final long NEW_TRIP =117250 ;
    public final long ACCEPT_DRIVER =117251 ;
    public final long WAIT_FOR_COMING_DRIVER=117252 ;
    public final long COMING_DRIVER =117253 ;
    public final long LOADING =117254 ;
    public final long START_TRIP =117255 ;
    public final long DELIVERED_LOAD =117256 ;
    public final long END_TRIP =117257 ;
    public final long PASSENGER_CANCEL_TRIP =117258 ;
    public final long DRIVER_CANCEL_TRIP =117259 ;
    public final long PROBLEM_TRIP =117260 ;
}
