package me.jdarby.nutrients

val FD_GROUP_file_items = load_FD_GROUP()

val FOOTNOTE_file_items = load_FOOTNOTE()

val NUT_DATA_file_items = load_NUT_DATA()

val DATSRCLN_file_items = load_DATSRCLN()

val DATA_SRC_file_items = load_DATA_SRC()

val NUTR_DEF_file_items = load_NUTR_DEF()

val SRC_CD_file_items = load_SRC_CD()

val DERIV_CD_file_items = load_DERIV_CD()

val WEIGHT_file_items = load_WEIGHT()

val LANGUAL_file_items = load_LANGUAL()

val LANGDESC_file_items = load_LANGDESC()

fun load_FOOD_DES_object(): List<FOOD_DES_object> {
    val foodGroupDescriptions = createFoodGroupDescriptionsWithFdGrp_Cd()
    val footnotes = createFootnotesWithNDB_No()
    val weights = createWeightsWithNDB_No()
    val langualFactors = createLangualFactorsWithNDB_No()
    val NUTR_DEF_objectsWithNutr_No = createNUTR_DEF_objectsWithNutr_No()
    val SRC_CD_objectsWithSrc_Cd = createSRC_CD_objectsWithSrc_Cd()
    val DERIV_CD_objectsWithDeriv_Cd = createDERIV_CD_objectsWithDeriv_Cd()
    val DATA_SRC_objectsWithDataSrc_ID = createDATA_SRC_objectsWithDataSrc_ID()
    val DATA_SRC_objectsWithNDB_No = createDATA_SRC_objectsWithNDB_No(DATA_SRC_objectsWithDataSrc_ID)
    val nutrientDataItems = createNutrientDataItemsWithNDB_No(NUTR_DEF_objectsWithNutr_No, SRC_CD_objectsWithSrc_Cd, DERIV_CD_objectsWithDeriv_Cd, DATA_SRC_objectsWithNDB_No)
    return load_FOOD_DES().map {
        FOOD_DES_object(
                foodGroupDescriptions.find { pair -> it.FdGrp_Cd == pair.first }!!.second,
                footnotes.find { pair -> it.NDB_No == pair.first }?.second ?: emptyList(),
                nutrientDataItems.find { pair -> it.NDB_No == pair.first }?.second ?: emptyList(),
                weights.find { pair -> it.NDB_No == pair.first }?.second ?: emptyList(),
                langualFactors.find { pair -> it.NDB_No == pair.first }?.second ?: emptyList(),
                it.Long_Desc,
                it.Shrt_Desc,
                it.ComName,
                it.ManufacName,
                it.Survey,
                it.Ref_desc,
                it.Refuse,
                it.SciName,
                it.N_Factor,
                it.Pro_Factor,
                it.Fat_Factor,
                it.CHO_Factor
        )
    }
}

fun createFoodGroupDescriptionsWithFdGrp_Cd(): List<Pair<String, FD_GROUP_object>> = FD_GROUP_file_items
        .map { Pair(it.FdGrp_Cd, FD_GROUP_object(it.FdGrp_Desc)) }

fun createFootnotesWithNDB_No(): List<Pair<String, List<FOOTNOTE_object>>> = FOOTNOTE_file_items
        .groupBy { it.NDB_No }
        .map { Pair(it.key, it.value.map { FOOTNOTE_object(it.Footnt_No, it.Footnt_Typ, it.Nutr_No, it.Footnt_Txt) }) }

fun createNutrientDataItemsWithNDB_No(NUTR_DEF_objectsWithNutr_No: List<Pair<String, NUTR_DEF_object>>, SRC_CD_objectsWithSrc_Cd: List<Pair<String, SRC_CD_object>>, DERIV_CD_objectsWithDeriv_Cd: List<Pair<String, DERIV_CD_object>>, DATA_SRC_objectsWithNDB_No: List<Pair<String, List<DATA_SRC_object>>>): List<Pair<String, List<NUT_DATA_object>>> = NUT_DATA_file_items
        .groupBy { it.NDB_No }
        .map { entry ->
            Pair(entry.key, entry.value.map {
                NUT_DATA_object(
                        DATA_SRC_objectsWithNDB_No.find { pair -> pair.first == it.NDB_No }?.second ?: emptyList(),//emptyList(),//getSourcesOfDataByNDB_No(it.NDB_No),
                        NUTR_DEF_objectsWithNutr_No.find { pair -> pair.first == it.Nutr_No }!!.second,
                        it.Nutr_Val,
                        it.Num_Data_Pts,
                        it.Std_Error,
                        SRC_CD_objectsWithSrc_Cd.find { pair -> pair.first == it.Src_Cd }!!.second,
                        DERIV_CD_objectsWithDeriv_Cd.find { pair -> pair.first == it.Deriv_Cd }?.second,
                        it.Ref_NDB_No,
                        it.Add_Ntr_Mark,
                        it.Num_Studies,
                        it.Min,
                        it.Max,
                        it.DF,
                        it.Low_EB,
                        it.Up_EB,
                        it.Stat_cmt,
                        it.AddMod_Date,
                        it.CC)
            })
        }

fun createDATA_SRC_objectsWithNDB_No(DATA_SRC_objectsWithDataSrc_ID: List<Pair<String, List<DATA_SRC_object>>>): List<Pair<String, List<DATA_SRC_object>>> = DATSRCLN_file_items
        .groupBy { it.NDB_No }
        .map { entry ->
            Pair(
                    entry.key,
                    entry.value.map {
                        DATSRCLN_file_item ->
                        DATA_SRC_objectsWithDataSrc_ID
                                //Unsure why there are entries with no sources, but apparently there are.
                                .find { it.first == DATSRCLN_file_item.DataSrc_ID }?.second
                                ?.map { DATA_SRC_object(it.Authors, it.Title, it.Year, it.Journal, it.Vol_City, it.Issue_State, it.Start_Page, it.End_Page) } ?: emptyList()
                    }.flatten()
            )
        }

fun createDATA_SRC_objectsWithDataSrc_ID(): List<Pair<String, List<DATA_SRC_object>>> = DATA_SRC_file_items
        .groupBy { it.DataSrc_ID }
        .map { entry -> Pair(entry.key, entry.value.map { DATA_SRC_object(it.Authors, it.Title, it.Year, it.Journal, it.Vol_City, it.Issue_State, it.Start_Page, it.End_Page) }) }

fun createNUTR_DEF_objectsWithNutr_No(): List<Pair<String, NUTR_DEF_object>> = NUTR_DEF_file_items
        .map { Pair(it.Nutr_No, NUTR_DEF_object(it.Units, it.Tagname, it.NutrDesc, it.Num_Dec, it.SR_Order)) }

fun createSRC_CD_objectsWithSrc_Cd(): List<Pair<String, SRC_CD_object>> = SRC_CD_file_items
        .map { Pair(it.Src_Cd, SRC_CD_object(it.SrcCd_Desc)) }

fun createDERIV_CD_objectsWithDeriv_Cd(): List<Pair<String, DERIV_CD_object>> = DERIV_CD_file_items
        .map { Pair(it.Deriv_Cd, DERIV_CD_object(it.Deriv_Desc)) }

fun createWeightsWithNDB_No(): List<Pair<String, List<WEIGHT_object>>> = WEIGHT_file_items
        .groupBy { it.NDB_No }
        .map {
            Pair(
                    it.key,
                    it.value.map {
                        WEIGHT_object(it.Seq, it.Amount, it.Msre_Desc, it.Gm_Wgt, it.Num_Data_Pts, it.Std_Dev)
                    }
            )
        }

fun createLangualFactorsWithNDB_No(): List<Pair<String, List<LANGUAL_object>>> = LANGUAL_file_items
        .groupBy { it.NDB_No }
        .map { entry ->
            Pair(entry.key, entry.value.map {
                LANGUAL_file_item ->
                LANGUAL_object(LANGDESC_file_items
                        .filter { it.Factor_Code == LANGUAL_file_item.Factor_Code }
                        .first()
                        .let { LANGDESC_object(it.Description) })
            })
        }