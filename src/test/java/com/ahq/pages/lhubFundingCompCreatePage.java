package com.ahq.pages;

import com.ahq.globals.BrowserGlobal;
import com.ahq.globals.web;
import com.ahq.locals.lhub;

import com.ahq.globals.Utils;
import com.ahq.addons.loc;
import com.qmetry.qaf.automation.step.QAFTestStep;
import io.cucumber.java.en.When;

import static com.qmetry.qaf.automation.core.ConfigurationManager.getBundle;


public class lhubFundingCompCreatePage {
    @QAFTestStep(description="Funding Components Form: Fill -Details- section with {0},{1},{2},{3},{4},{5},{6}")
    public void fundingComponentsCreateFillDetailsSectionWith(String code,String desc,String billName,String enablePaymentMode,String glNumber,String mndtSupDoc,String supDocs) throws Exception {
        web.input(code + web.getExecDateTime(),"[Details] Funding component code ::2");
        web.input(desc + web.getExecDateTime(),"Funding component description");
        web.input(billName + web.getExecDateTime(),"Name in billing (to be displayed in invoice)");
        if (enablePaymentMode.equalsIgnoreCase("Yes")) {
            web.clickCheckBox("Enable as payment mode");
        }
        web.selectDropdownByInput(glNumber,"GL number");
        web.clickRadioButton(mndtSupDoc,"Mandatory supporting documents?");
        lhub.addSupportDocuments_LHUB(supDocs);
        web.clickSwitchButton("[Criteria & rates] SQL mode");
    }



    @QAFTestStep(description="FundingCompCreate-Page: I fill following details {0},{1},{2},{3},{4},{5},{6},{7},{8},{9},{10},{11},{12},{13},{14},{15}")
    public void fundingCompCreatePageIFillFollowingDetails(String code,String desc,String billing_name,String gl_number,String payment_mode,String mandatory_supporting_documents,String gst_applicable,String supporting_documents, String prerequisite_desc,String prerequisite_sql_mode,String prerequisite_formula, String criteria_desc,String criteria_sql_mode,String criteria_formula, String rate_sql_mode,String rate_formula) throws Exception{
        String temp_gen_value = Utils.dateTime_currentDateTime();
        getBundle().setProperty("auto.page.name","fundingCompCreatePage");
        web.input(code + temp_gen_value,"Funding component code");
//        BrowserGlobal.iInputInTo(code + temp_gen_value,loc.pattern("FundingCompCreate","input","Funding component code",null));
        BrowserGlobal.iInputInTo(desc + temp_gen_value,loc.pattern("FundingCompCreate","textarea","Funding component description",null));
        BrowserGlobal.iInputInTo(billing_name + temp_gen_value,loc.pattern("FundingCompCreate","input","Name in billing (to be displayed in invoice)",null));
        BrowserGlobal.iClickOn(loc.pattern("FundingCompCreate","checkbox","Enable as payment mode",null));
        BrowserGlobal.iInputSearch(payment_mode, loc.pattern("FundingCompCreate","input","Payment mode",null));
        BrowserGlobal.iClickOn(loc.pattern("FundingCompCreate","radio_button","Mandatory supporting documents?:"+mandatory_supporting_documents,null));
        lhub.addSupportDocuments_LHUB(supporting_documents);
        BrowserGlobal.iClickOn(loc.pattern("FundingCompCreate","radio_button","GST applicable?:"+gst_applicable,null));

        //Prerequisite Entries
        BrowserGlobal.iInputInTo(prerequisite_desc,loc.pattern("FundingCompCreate","textarea","Prerequisite description",null));
        lhub.clickSwitchButton("FundingCompCreate","SQL mode",prerequisite_sql_mode,"1");
        //        BrowserGlobal.iInputInTo(Utils.base64_decrypt(prerequisite_formula), "loc.lhub.fundingComponentCreate.textarea.prerequisiteFormula");
        BrowserGlobal.iInputInTo(Utils.base64_decrypt(prerequisite_formula), loc.pattern("FundingCompCreate","textarea.formula","Prerequisite formula",null));
//      lhub.clickValidateButtonInstance("1");

        //Criteria Entries
        BrowserGlobal.iInputInTo(criteria_desc,loc.pattern("FundingCompCreate","textarea","Criteria description",null));
        lhub.clickSwitchButton("FundingCompCreate","SQL mode",criteria_sql_mode,"2");
        BrowserGlobal.iInputInTo(Utils.base64_decrypt(criteria_formula), loc.pattern("FundingCompCreate","textarea.formula","Criteria formula",null));
//        lhub.clickValidateButtonInstance("2");

        //Rate Entries
        lhub.clickSwitchButton("FundingCompCreate","SQL mode",criteria_sql_mode,"3");
        BrowserGlobal.iInputInTo(Utils.base64_decrypt(rate_formula), loc.pattern("FundingCompCreate","textarea.formula","Rate formula",null));
//        lhub.clickValidateButtonInstance("3");

        BrowserGlobal.iClickOn(loc.pattern("FundingCompCreate","button","Save as draft",null));

    }

}

