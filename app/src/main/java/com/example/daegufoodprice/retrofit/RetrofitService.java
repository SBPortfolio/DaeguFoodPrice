package com.example.daegufoodprice.retrofit;

import com.example.daegufoodprice.model.PriceData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitService {
    @GET("openapi/{serviceKey}/json/Grid_20141225000000000163_1/1/100")
    Call<PriceData> getListRepos(@Path("serviceKey") String serviceKey
            , @Query("EXAMIN_DE") String examin_de
            , @Query("AREA_CD") String area_cd
            , @Query("FRMPRD_CATGORY_CD") int frmprd_catgory_cd
    );

    @GET("openapi/{serviceKey}/json/Grid_20141225000000000163_1/1/50")
    Call<PriceData> getListData(@Path("serviceKey") String serviceKey
            , @Query("EXAMIN_DE") String examin_de
            , @Query("FRMPRD_CATGORY_CD") String frmprd_catgory_cd
            , @Query("PRDLST_CD") String prdlst_cd
            , @Query("AREA_CD") String area_cd
    );
}
