package com.example.application.views;

//import java.text.Normalizer.Form;
//import com.vaadin.flow.component.notification.*;
import java.time.LocalDate;

//import com.example.application.entities.MembersBean;
//import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
//import org.vaadin.lineawesome.LineAwesomeIconUrl;
//import com.example.application.*;
//import com.example.examplefeature.MembershipFeesBean;  -nv used  - under VScde identified
//import com.example.examplefeature.MembershipFeesBeanService; -nv used
//import com.vaadin.flow.component.Component;
//import com.vaadin.flow.component.ComponentEvent;
//import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
////import com.vaadin.flow.component.orderedlayout.VerticalLayout;
//import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
//import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.example.application.entities.*;
import com.example.application.services.*;
//mport java.util.List;
//import java.util.ArrayList;
import com.vaadin.flow.component.textfield.TextField;
//import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
//import jakarta.persistence.*;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
//import com.vaadin.flow.router.Menu;
//import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("MemberPaymentForm")
//@Route("target-view/:parameter")
public class MemberPaymentForm extends VerticalLayout implements HasUrlParameter<String>{

	private static final long serialVersionUID = 1L;
	TextField fullNameField = new TextField("Full Name");
	TextField phoneField = new TextField("Phone");
	DatePicker dateStartField = new DatePicker("Start Date");
	DatePicker dateEndField   = new DatePicker("End Date");
	Button addPmtButton = new Button("Save");
	Button cancelPmtButton = new Button("Cancel");
	TextField amountField = new TextField("Amount");
	String idpassed;
	LocalDate currentDate = LocalDate.now();
	H1 header = new H1("Lee's Member Payment "); 
	FormLayout form = new FormLayout();
//	Long idpassedL;

	ComboBox<String> comboBoxPmtField = new ComboBox<>("Payment Method",
			"zelle", "cash", "check", "prorate zelle", "prorate cash",  "prorate check",
													   "zelle + late fee", "cash + late fee", "check + late fee", "pending");

	/*ComboBox<String> comboBoxAmtField = new ComboBox<>("Amount", "2.00 - 1 day", "5.00 - 2 days", "7.00 - 3 days", "9.00 - 4 days", "12.00 - 5 days", "14.00 - 6 days", "16.00 - 7 days",	
													   "19.00 - 8 days", "21.00 - 9 days", "23.00 - 10 days", "26.00 - 11 days", "28.00 - 12 days ", "30.00 - 13 days", "33.00 - 14 days", 
		"35.00 - 15 days", "37.00 - 16 days", "40.00 - 17 days", "42.00 - 18 days", "44.00 - 19 days", "47.00 - 20 days", "49.00 - 21 days", "51.00 - 22 days", "54.00 - 23 days", "56.00 - 24 days", "58.00 - 25 days", "61.00 - 26 days", "63.00 - 27 days",
								   "65.00 - 28 days", "68.00 - 29 days", "10.00", "20.00", "30.00", "40.00", "50.00",
													   "60.00", "70.00", "80.00", "105.00", "120.00", "130.00", "140.00", "160.00", "200.00", "210.00",											
		"350.00", "400.00", "420.00", "700.00", "1200.00", "1400.00"); */

	
	 ComboBox<String> comboBoxAmtField = new ComboBox<>("Amount", "3.00 - 1 day", "5.00 - 2 days", "8.00 - 3 days", "11.00- 4 days",
	"13.00 - 5 days", "16.00 - 6 days", "19.00 - 7 days",	
	   "21.00 - 8 days", "24.00 - 9 days", "27.00 - 10 days", "29.00 - 11 days",
	 "32.00 - 12 days ", "35.00 - 13 days", "37.00 - 14 days", 
		"40.00 - 15 days", "43.00 - 16 days", "45.00 - 17 days", "48.00 - 18 days", "51.00 - 19 days", "53.00 - 20 days", 
	 "56.00 - 21 days", "59.00 - 22 days", "61.00 - 23 days", "64.00 - 24 days", "67.00 - 25 days", "69.00 - 26 days", "72.00 - 27 days",
		  "75.00 - 28 days", "77.00 - 29 days", 
	"69.00 - discount", "80.00", "138.00 - discount", "160.00", "240.00", "320.00", "400.00", "480.00", 										
	"800.00", "960.00", "1040.00", "1200.00", "1600.00",
    "2.00 - 1 day - couples",  "5.00 - 2 days - couples", "7.00 - 3 days - couples", "9.00 - 4 days - couples", "12.00 - 5 days - couples",
	 
	"14.00 - 6 days - couples",  "16.00 - 7 days - couples", "19.00 - 8 days - couples", "21.00 - 9 days - couples", "23.00 - 10 days - couples",
														
	"26.00 - 11 days - couples",  "28.00 - 12 days - couples", "30.00 - 13 days - couples", "33.00 - 14 days - couples", "35.00 - 15 days - couples",

	"37.00 - 16 days - couples",  "40.00 - 17 days - couples", "42.00 - 18 days - couples", "44.00 - 19 days - couples", "47.00 - 20 days - couples",

	"49.00 - 21 days - couples",  "51.00 - 22 days - couples", "54.00 - 23 days - couples", "56.00 - 24 days - couples", "58.00 - 25 days - couples",

	"61.00 - 26 days - couples",  "63.00 - 27 days - couples", "65.00 - 28 days - couples", "68.00 - 29 days - couples", "70.00 - 30 days - couples"
													   ); 


	//comboBoxAmtField.setAllowCustomValue(true);

	// private Binder<MembershipFeesBean> binder;

	private Binder<MembershipFeesBean> binder = new Binder<>(MembershipFeesBean.class);

	 private MembershipFeesBean membershipFeesBean;

	 private final MembershipFeesBeanService membershipFeesBeanService;

	// private EntityManager entityManager;





	// public MemberForm (MembersBeanService membersBeanService) {
	//		this.membersBeanService = membersBeanService;
	   public  MemberPaymentForm (MembershipFeesBeanService membershipFeesBeanService) {
		   this.membershipFeesBeanService = membershipFeesBeanService;
	//	   System.out.println("In Constructor");



    //configureForm(); cannot have these statements here because I need the setParameter to run first
     // 	 configureButton();

    //configureBind();

     // configureForm();







       }
	   @Override
		public void setParameter(BeforeEvent event, String pN) {
	       //  Use the parameter
	    //     System.out.println("setParameter Interface Method " );

	       String paramValue = pN;

	       String data = paramValue;
	 //      System.out.println("Passed " + pN);

	    //   System.out.println("paramValue =  " + paramValue);
	       /*
	        * Passed data is a string of fields separated by "," comma, the split methods scans the string
	        * and separates by "," each is placed in a string array and then select by subscript
	        *  **/

	       String[] items = data.split(","); // Splits at each comma adding to the array
	     //  System.out.println("item 0 index " + items[0]);
	    //   System.out.println("item 1 index " + items[1]);
	     //  System.out.println("item 2 index " + items[2]);
	      //    System.out.println("item 3 index " + items[3]);

	          idpassed = items[3];

	   //    phoneField.addClassName("colored6-grid");
	      phoneField.setValue(items[0]);
	      phoneField.setReadOnly(true);
	    //   System.out.println(" right after set phoneField is " + phoneField.getValue());

	   //    fullNameField.addClassName("colored4b-grid");
	       fullNameField.setValue(items[1] + " " + items[2]);
	       fullNameField.setReadOnly(true);
	     //  System.out.println(" right after set fullNameField is " + fullNameField.getValue());


	      configureForm();

	      configureBind();

	      cancelPmtButton.addClickListener(click ->  UI.getCurrent().navigate(GridtobeView.class));


	       addPmtButton.addClickListener(click -> {

	    	   if (dateStartField.isEmpty()  || dateEndField.isEmpty()
	    			   || comboBoxAmtField.isEmpty()  || comboBoxPmtField.isEmpty())
	    	   {
	    		   Notification.show("All fields require entry",
	 	 		 	   		  10000, Notification.Position.BOTTOM_START);
	    		 

	    	   } else {
	    		   if (dateEndField.getValue().isAfter( dateStartField.getValue()))  {
		    			if	   (dateEndField.getValue().isAfter(currentDate.minusDays(1))) {

	        //                 MembershipFeesBean membershipFeesBean = new MembershipFeesBean();
	               	               try
	            	              {
	            	                 MembershipFeesBean mb = new MembershipFeesBean();

	                              
	            	                 mb.setmembersId(idpassed);

	            	                 binder.writeBean(mb);
	    	        	    
	    	   	                        membershipFeesBeanService.save(mb);
	    	      	                    Notification notification = Notification.show("Payment Successful");
	    	      	                    notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
									    System.out.println("Member Id = " + idpassed);
									    System.out.println("Payment Successful");

	    	                 
	    	      	                   UI.getCurrent().navigate(GridtobeView.class);
	    	                          } catch (ValidationException e) {
	    		                         System.out.println("Validation Exception " + e);
	    	                                  }

											}
											else
											{
											   Notification.show("End Date must be greater than Start Date and Not less than today date",
		 	 		 	             		  13000, Notification.Position.BOTTOM_START);
	    			                           Notification notification = Notification.show("Error in Data Entry");
	           		      	                   notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
	    			          
										}

	                 }
					 else
					 {
					  Notification notification = Notification.show("End Date must be greater than Start Date");
	    			  notification.addThemeVariants(NotificationVariant.LUMO_ERROR); }
	    	   }
			}
	    	   );

	   }












@SuppressWarnings("null")

	private void configureBind() {
	//	System.out.println("configureBind Method");

		 dateStartField.setPlaceholder("Select a date...");
	//	 dateStartField.getStyle()
	 //     .set("background-color", "#e3f2fd");

		 dateEndField.setPlaceholder("Select a date...");
	//	 dateEndField.getStyle()
	 //     .set("background-color", "#e3f2fd");

		 comboBoxAmtField.setPlaceholder("Select an amount..."); // Optional placeholder
	//	 comboBoxAmtField.getStyle()
	//      .set("background-color", "#e3f2fd");

		 comboBoxPmtField.setPlaceholder("Select a payment type...");
	     comboBoxPmtField.setAllowCustomValue(true);
	  //   comboBoxPmtField.getStyle()
	  //    .set("background-color", "#e3f2fd");
//	     comboBoxAmtField.setEmptySelectionAllowed(true);

		 binder.setBean(membershipFeesBean);   // needs to be done before any binding


	//	 this was used to changed the string to a long id, but changed strategy and used in a string membersid
	//	 MembershipFeesBeanService mb = MembershipFeesBeanService;
	//	 Long idpassedL = Long.valueOf(idpassed);
	//	 mb.setId(idpassedL);

		binder.bind(fullNameField, MembershipFeesBean::getfullName, MembershipFeesBean::setfullName);

	    binder.bind(phoneField, MembershipFeesBean::getphoneNumber, MembershipFeesBean::setphoneNumber);



		binder.forField(dateStartField)
		.asRequired("Date is required")
		.bind(MembershipFeesBean::getstartDate, MembershipFeesBean::setstartDate);

		binder.forField(dateEndField)
		.asRequired("Date is required")
		.bind(MembershipFeesBean::getendDate, MembershipFeesBean::setendDate);

		binder.forField(comboBoxPmtField)
		.asRequired("Payment Type")
		.bind(MembershipFeesBean::getpaymentType, MembershipFeesBean::setpaymentType);

		binder.forField(comboBoxAmtField)
		.asRequired("Amount Required")
		.bind(MembershipFeesBean::getamount, MembershipFeesBean::setamount);








	}








         private void configureForm() {
       //  System.out.println("Configure Form Method ");
         addPmtButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

         cancelPmtButton.addThemeVariants(ButtonVariant.LUMO_CONTRAST);

        

		    form.getStyle().set("--vaadin-input-field-border-width", "3px");

 			form.add(
 					fullNameField,
 					phoneField,
 					dateStartField,
 					dateEndField,
 					comboBoxAmtField,
 			    	comboBoxPmtField,
 					addPmtButton,
 					cancelPmtButton	
 					);

			add(header, form);




}
}
