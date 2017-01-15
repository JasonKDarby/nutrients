package me.jdarby.nutrients

data class FOOD_DES_object(
        val foodGroupDescription:   FD_GROUP_object,
        val footnotes:              List<FOOTNOTE_object>,
        val nutrientDataItems:      List<NUT_DATA_object>,
        val weights:                List<WEIGHT_object>,
        val LangualFactors:         List<LANGUAL_object>,
        val Long_Desc:              String,
        val Shrt_Desc:              String,
        val ComName:                String?,
        val ManufacName:            String?,
        val Survey:                 String?,
        val Ref_desc:               String?,
        val Refuse:                 Int?,
        val SciName:                String?,
        val N_Factor:               Double?,
        val Pro_Factor:             Double?,
        val Fat_Factor:             Double?,
        val CHO_Factor:             Double?
)

data class FD_GROUP_object(
        val FdGrp_Desc:     String
)

data class FOOTNOTE_object(
        val Footnt_No:      String,
        val Footnt_Typ:     String,
        val Nutr_No:        String,
        val Footnt_Txt:     String
)

data class NUT_DATA_object(
        val sourcesOfData:      List<DATA_SRC_object>,
        val nutrientDefinition: NUTR_DEF_object,
        val Nutr_Val:           Double,
        val Num_Data_Pts:       Int,
        val Std_Error:          Double?,
        val Src_Cd:             SRC_CD_object,
        val Deriv_Cd:           DERIV_CD_object?,
        val Ref_NDB_No:         String?,
        val Add_Ntr_Mark:       String?,
        val Num_Studies:        Int?,
        val Min:                Double?,
        val Max:                Double?,
        val DF:                 Int?,
        val Low_EB:             Double?,
        val Up_EB:              Double?,
        val Stat_cmt:           String?,
        val AddMod_Date:        String?,
        val CC:                 String?
)

data class WEIGHT_object(
        val Seq:            String,
        val Amount:         Double,
        val Msre_Desc:      String,
        val Gm_Wgt:         Double,
        val Num_Data_Pts:   Int?,
        val Std_Dev:        Double?
)

data class LANGUAL_object(
        val description:    LANGDESC_object
)

data class LANGDESC_object(
        val Description:    String
)

data class NUTR_DEF_object(
        val Units:          String,
        val Tagname:        String?,
        val NutrDesc:       String,
        val Num_Dec:        String,
        val SR_Order:       Int
)

data class SRC_CD_object(
        val SrcCd_Desc:     String
)

data class DERIV_CD_object(
        val Deriv_Desc:     String
)

data class DATA_SRC_object(
        val Authors:        List<String>?,
        val Title:          String,
        val Year:           String?,
        val Journal:        String?,
        val Vol_City:       String?,
        val Issue_State:    String?,
        val Start_Page:     String?,
        val End_Page:       String?
)