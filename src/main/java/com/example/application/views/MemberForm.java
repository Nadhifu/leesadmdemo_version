package com.example.application.views;

import com.vaadin.flow.component.textfield.*;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;
//import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
//import com.vaadin.flow.component.notification.Notification;
import com.example.application.entities.MembersBean;
import com.example.application.services.MembersBeanService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.*;
import com.vaadin.flow.component.formlayout.FormLayout;

@Route("memberform")
public class MemberForm extends VerticalLayout implements HasUrlParameter<String>
{
	 
   
	private static final long serialVersionUID = 1L;
	EmailField emailField = new EmailField("Email");
	TextField firstNameField = new TextField("First Name");
	TextField lastNameField = new TextField( "Last Name");
	TextField phoneNumberField = new TextField("Phone");
	 int indexcnt = 0;
	 H1 header = new H1("Lee's Membership Enrollment ");
    FormLayout form = new FormLayout();

	Button saveButtonField = new Button("Confirm New Member/Update Existing Member");
	Button cancelButtonField = new Button("Cancel Creating New Member");

	
	private final Binder<MembersBean> binder = new Binder<>(MembersBean.class);
    private final MembersBeanService membersBeanService;
    String wsid;
    Long wsidLong;
	
	
	public MemberForm (MembersBeanService membersBeanService) {
		this.membersBeanService = membersBeanService;
		//System.out.println("MemberForm Constructor");
		
	}
	
	@Override
	public void setParameter(BeforeEvent event, String pN) {
        // Use the parameter
		// System.out.println("setParameter method");
       String paramValue = pN;
    //   System.out.println("Accepted parameter is " + paramValue);
  
    //   System.out.println("Event is " + event);
   
       String data = paramValue;
    //   System.out.println("Passed " + pN);
       
    //   System.out.println("paramValue =  " + paramValue);
       /*  
        * Passed data is a string of fields separated by "," comma, the split methods scans the string
        * and separates by "," each is placed in a string array and then select by subscript
        *  **/
       
       String [] items = data.split(","); // Splits at each comma
     //  System.out.println("item 0 index " + items[0]
     //  System.out.println("item 1 index " + items[1]);
      // System.out.println("item 2 index " + items[2]);
      // System.out.println("item 3 index " + items[3]);
    //   System.out.print("item 4 index " + items[4]);
     //  System.out.println(" data array length is " + items.length);
       
      
   
       
       indexcnt = items.length;
       if (indexcnt > 4 ) {	    	   
    	   wsid = items[4];	  
       }
    	
    
       
       phoneNumberField.setValue(items[0]);
    //   phoneNumberField.setReadOnly(true);
       phoneNumberField.setReadOnly(false);
     
       firstNameField.addClassName("colored4-grid");
       firstNameField.setValue(items[1]);
       firstNameField.setReadOnly(false);
       
       lastNameField.addClassName("colored4-grid");
       lastNameField.setValue(items[2]);
       lastNameField.setReadOnly(false);
       
       emailField.addClassName("colored4-grid");
       emailField.setValue(items[3]);
       emailField.setReadOnly(false);
       
     //  cancelButtonField.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
       
       configureForm();
       
       cancelButtonField.addClickListener(click ->  UI.getCurrent().navigate(GridtobeView.class));
   
       saveButtonField.addClickListener(click -> configureBinding());
      
  
	


     
   }    
	@SuppressWarnings("null")

	private void configureBinding() {
		binder.forField(emailField)
        .bind("eMail");
		binder.forField(firstNameField)
        .bind("firstName");
		binder.forField(lastNameField)
        .bind("lastName");
	//	binder.forField(phoneNumberField)
    //    .bind("phoneNumber");

   String digitsOnly = phoneNumberField.getValue();
   String formatted = digitsOnly.replaceFirst("(\\d{3})(\\d{3})(\\d{4})", "($1) $2-$3");

		phoneNumberField.setValue(formatted);	
		  binder.forField(phoneNumberField)
       //   .withValidator(
       //     value ->  value.length() == 10,
       //      "Area Code+Number")           
          .bind(MembersBean::getphoneNumber, MembersBean::setphoneNumber);
		  MembersBean mb = new MembersBean();
		
	
	 if (indexcnt > 4) {   
	        wsidLong = Long.valueOf(wsid);
	        mb.setid(wsidLong);
	 }
		  
  
		  
		  
		  
		  if (binder.writeBeanIfValid(mb)) {
		     try {
	        	binder.writeBean(mb);
	        	membersBeanService.save(mb);
	            UI.getCurrent().navigate(GridtobeView.class);
		}
		      catch (ValidationException e) {
	     	        System.out.println("Validation Exception " + e);
	     	 		
		};
		  };
	};
	



	private void configureForm() {
		
	    saveButtonField.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
	  // commentating all set so the global color is applied  
	 //   TextField textField = new TextField("Inline Style");
	  //  firstNameField.getStyle()
	   //   .set("background-color", "#e3f2fd");
	  //      .set("--lumo-text-field-background-color", "#e3f2fd");
	    
	  //  lastNameField.getStyle()
      //  .set("background-color", "#e3f2fd");
     //   .set("--lumo-text-field-background-color", "#g3f2fd");
	    
	  //  emailField.getStyle()
      //  .set("background-color", "#e3f2fd");
     //   .set("--lumo-text-field-background-color", "#g3f2fd");
	    
	 //   phoneNumberField.getStyle()
      //  .set("background-color", "#e3f2fd");
     //   .set("--lumo-text-field-background-color", "#e3f2fd");

	  form.getStyle().set("--vaadin-input-field-border-width", "3px");
	  
        form.add(firstNameField, lastNameField, emailField,
			phoneNumberField, saveButtonField, cancelButtonField);
	
		add(header, form);

	
		
		
    
    			
    				
            	}	
    	 
     
};	
		
  
	

