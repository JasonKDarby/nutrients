package me.jdarby.nutrients

//DATA_SRC.txt
data class DATA_SRC(
        val DataSrc_ID:     String,
        val Authors:        List<String>?,
        val Title:          String,
        val Year:           String?,
        val Journal:        String?,
        val Vol_City:       String?,
        val Issue_State:    String?,
        val Start_Page:     String?,
        val End_Page:       String?
)

//DATSRCLN.txt
data class DATSRCLN(
        val NDB_No:         String,
        val Nutr_No:        String?,
        val DataSrc_ID:     String
)

//DERIV_CD.txt
data class DERIV_CD(
        val Deriv_Cd:       String,
        val Deriv_Desc:     String
)

//FD_GROUP.txt
data class FD_GROUP(
        val FdGrp_Cd:       String,
        val FdGrp_Desc:     String
)

//FOOD_DES.txt
data class FOOD_DES(
        val NDB_No:         String,
        val FdGrp_Cd:       String,
        val Long_Desc:      String,
        val Shrt_Desc:      String,
        val ComName:        String?,
        val ManufacName:    String?,
        val Survey:         String?,
        val Ref_desc:       String?,
        val Refuse:         Int?,
        val SciName:        String?,
        val N_Factor:       Double?,
        val Pro_Factor:     Double?,
        val Fat_Factor:     Double?,
        val CHO_Factor:     Double?
)

//FOOTNOTE.txt
data class FOOTNOTE(
        val NDB_No:         String,
        val Footnt_No:      String,
        val Footnt_Typ:     String,
        val Nutr_No:        String,
        val Footnt_Txt:     String
)

//LANGDESC.txt
data class LANGDESC(
        val Factor_Code:    String,
        val Description:    String
)

//LANGUAL.txt
data class LANGUAL(
        val NDB_No:         String,
        val Factor_Code:    String
)

//NUT_DATA.txt
data class NUT_DATA(
        val NDB_No:         String,
        val Nutr_No:        String,
        val Nutr_Val:       Double,
        val Num_Data_Pts:   Int,
        val Std_Error:      Double?,
        val Src_Cd:         String,
        val Deriv_Cd:       String?,
        val Ref_NDB_No:     String?,
        val Add_Ntr_Mark:   String?,
        val Num_Studies:    Int?,
        val Min:            Double?,
        val Max:            Double?,
        val DF:             Int?,
        val Low_EB:         Double?,
        val Up_EB:          Double?,
        val Stat_cmt:       String?,
        val AddMod_Date:    String?,
        val CC:             String?
)

//NUTR_DEF.txt
data class NUTR_DEF(
        val Nutr_No:        String,
        val Units:          String,
        val Tagname:        String?,
        val NutrDesc:       String,
        val Num_Dec:        String,
        val SR_Order:       Int
)

//SRC_CD.txt
data class SRC_CD(
        val Src_Cd:         String,
        val SrcCd_Desc:     String
)

//WEIGHT.txt
data class WEIGHT(
        val NDB_No:         String,
        val Seq:            String,
        val Amount:         Double,
        val Msre_Desc:      String,
        val Gm_Wgt:         Double,
        val Num_Data_Pts:   Int?,
        val Std_Dev:        Double?
)

