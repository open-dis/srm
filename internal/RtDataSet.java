
package SRM;

class RtDataSet
{
    public String        _label;
    public String        _description;
    public SRM_ORM_Code  _orm_code;
    public SRM_RT_Code   _rt_code;
    public double        _delta_x;
    public double        _delta_y;
    public double        _delta_z;
    public double        _omega_1;
    public double        _omega_2;
    public double        _omega_3;
    public double        _delta_scale;
    public double        _region_ll_lat;
    public double        _region_ll_long;
    public double        _region_ur_lat;
    public double        _region_ur_long;

    protected RtDataSet(String        label,
                        String        description,
                        SRM_ORM_Code  orm_code,
                        SRM_RT_Code   rt_code,
                        double        delta_x,
                        double        delta_y,
                        double        delta_z,
                        double        omega_1,
                        double        omega_2,
                        double        omega_3,
                        double        delta_scale,
                        double        region_ll_lat,
                        double        region_ll_long,
                        double        region_ur_lat,
                        double        region_ur_long )
    {
        _label = label;
        _description = description;
        _orm_code = orm_code;
        _rt_code = rt_code;
        _delta_x = delta_x;
        _delta_y = delta_y;
        _delta_z = delta_z;
        _omega_1 = omega_1;
        _omega_2 = omega_2;
        _omega_3 = omega_3;
        _delta_scale = delta_scale;
        _region_ll_lat = region_ll_lat;
        _region_ll_long = region_ll_long;
        _region_ur_lat = region_ur_lat;
        _region_ur_long = region_ur_long;
    }

    protected static boolean isValidPair( SRM_ORM_Code orm_code, SRM_RT_Code rt_code )
    {
        RtDataSet retRtData = null;

        boolean ret_val = false;

        try
        {
            retRtData = RtDataSet.getElem( rt_code );

            if ( retRtData._orm_code == orm_code )
                ret_val = true;

            // this is the case where the RT data was not found ( out of vector bounds )
        }
        catch ( ArrayIndexOutOfBoundsException ex )
        {
            ret_val = false;
        }
        catch ( SrmException ex )
        {
            ret_val = false;
        }
        return ret_val;
    }

    public static RtDataSet getElem( SRM_RT_Code code ) throws SrmException
    {
        if (code.toInt() >= 0 && code.toInt() <= 269 )
        {
            // this table has RTs from 0 to 269
            return RtDataSet1.getElem( code );
        }
        else // this table has RTs from 270 and up
        {
            return RtDataSet2.getElem( code );
        }
    }
}
