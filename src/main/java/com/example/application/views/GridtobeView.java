
package com.example.application.views;


import com.vaadin.flow.component.grid.FooterRow;
//import com.example.application.views.MembersBeanService;  
//import com.example.application.view.MemberIndividualReport;  -nv used
//import com.example.application.views.MembersBean;  
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.grid.FooterRow.FooterCell;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Menu;
//import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.lineawesome.LineAwesomeIconUrl;
import com.vaadin.flow.component.textfield.*;
import java.util.List;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.validator.EmailValidator;
import com.vaadin.flow.component.UI;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import com.example.application.entities.MembersBean;
import com.example.application.services.MembersBeanService;


@Route("GridtobeView")
//@PageTitle("MEMBERS HOME PAGE INFORMATION")
@Menu(order = 0, icon = LineAwesomeIconUrl.FILE)
public class  GridtobeView extends VerticalLayout {

    private static final long serialVersionUID = 1L;
    
    Grid<MembersBean> grid = new Grid<>(MembersBean.class);
    private final Binder<MembersBean> binder = new Binder<>(MembersBean.class);
    
    HorizontalLayout form = new HorizontalLayout();
    HorizontalLayout controls = new HorizontalLayout();
    TextField addressField = new TextField("Address");
	EmailField emailField = new EmailField("Email");
	TextField firstNameField = new TextField("First Name");
	TextField lastNameField = new TextField("Last Name");
	TextField phoneNumberField = new TextField("Phone Number");
	Long idpassed;

	H1 header = new H1("Demo Administration Home ");


	private final MembersBeanService membersBeanService;

	public GridtobeView(MembersBeanService membersBeanService) {
           this.membersBeanService =  membersBeanService;
		   
		// UI.getCurrent().getPage().setTitle("MEMBERS HOME PAGE INFORMATION");
    
	
        configureGrid();
        
        configureForm();    
        
        configureBinding();
        
        setSpacing(false);
        
        //System.out.println("Grid ViewProduction test 1");
        		
                          }


	private void configureForm() {
		
	//	form.addClassName("colored-layout");
	
         form.getStyle().set("--vaadin-input-field-border-width", "3px");
     //   form.getStyle().set( "border" , "6px solid Blue" ) ; 


		form.addClassName("colored4b-grid");
        controls.addClassName("colored2-layout");
       
	      
	        //firstNameField.addThemeVariants(TextFieldVariant.LUMO_SMALL);
	        
	    //    Button buttonAddField = new Button("Add new member");
	     //   buttonAddField.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
	        
	       
	       
	    //    form.setEnabled(false);   initial view was protected and only activated when a selection
	    //    controls.setEnabled(false);  but changed that to just be accessible 
	        
	    //    buttonAddField.addClickListener(click -> System.out.println("ADD SELECTED"));
	    //    Notification.show("SAVED MEMBER",13000, Notification.Position.BOTTOM_START);
	        //////////////////////////////////////////////////////////////////////////////
	     //   var value = phoneNumberField.getValue();
        //	var value2 = firstNameField.getValue();
        //	var value3 = lastNameField.getValue();
        //	var value4 = emailField.getValue(); 
	        //	System.out.println("phonefield length is "
        	
	        Button buttonAddField2 = new Button("Membership Payment", e -> {
	        	var value = phoneNumberField.getValue();
	        	var value2 = firstNameField.getValue();
	        	var value3 = lastNameField.getValue();

	
	  	        	
	            if (value.length() > 0 & value2.length() > 0 & value3.length() > 0
	            		& idpassed != null) {    
	        	    UI.getCurrent().navigate(MemberPaymentForm.class,        		    	
	        	    		value + "," + value2 +
	        	     	     		  "," + value3 + "," + idpassed);	}      	             
	        		
	     
	         	else {
	         		
	         		Notification notification = Notification.show("Select Member From Grid");
	         		notification.addThemeVariants(NotificationVariant.LUMO_WARNING);
	         	//	notification.addThemeVariants(NotificationVariant.LUMO_CONTRAST);

	         		// Available variants:
	         		// - LUMO_SUCCESS (green)
	         		// - LUMO_ERROR (red)
	         		// - LUMO_CONTRAST (high contrast)
	             //   Notification.show("Data for payment must be selected from grid create a member record",
                 //    13000, Notification.Position.BOTTOM_START);
	               
	           //      Notification notification = new Notification();
				//	notification.addThemeVariants(NotificationVariant.LUMO_ERROR);

	                 // Available variants:
	                 // - LUMO_SUCCESS (green)
	                 // - LUMO_ERROR (red)
	                 // - LUMO_CONTRAST (high contrast)
	                 }
	     
	            }
	        );
	        
	        
	        Button buttonIndField = new Button("Members Fees", e -> {
	        	var valueI = phoneNumberField.getValue();
	        	var value2I = firstNameField.getValue();
	        	var value3I = lastNameField.getValue();
	   
	  	        	
	            if (valueI.length() > 0 & value2I.length() > 0 & value3I.length() > 0
	            	& idpassed != null) {    
	                	    UI.getCurrent().navigate(MemberIndividualReport.class,        		    	
	        	    		valueI + "," + value2I +
	        	     	     		  "," + value3I + "," + idpassed);	}      	             
	        		
	     
	        	else {
	            	
	            		Notification notification = Notification.show("Select Member From Grid");
		         		notification.addThemeVariants(NotificationVariant.LUMO_WARNING);
	               //    Notification.show("Member must be selected from grid",       
                  // 13000, Notification.Position.BOTTOM_START);
	                   }
	     
	            }
	        );
	
	       
	       
	
	        // these values are being passed to the members form, 
	        // values concatenated and delimited by "," as one string
	 
	       	   Button buttonAddField = new Button("Create New/Update ", e -> {
	           	var valueb = phoneNumberField.getValue();
	           	var value2b = firstNameField.getValue();
	           	var value3b = lastNameField.getValue();
	           	var value4b = emailField.getValue();
	        	 if (valueb.length() > 0 & value2b.length() > 0 & value3b.length() > 0
	        			 & value4b.length() > 0 & idpassed == null) { 
		           UI.getCurrent().navigate(MemberForm.class,    //import the object when using navigate
		        		   valueb + "," + value2b +
 	     	     		  "," + value3b + "," + value4b);   //create record no id yet
		       
	        	 }
	        	 else
	        		 if (valueb.length() > 0 & value2b.length() > 0 & value3b.length() > 0
		        			 & value4b.length() > 0) { 
			           UI.getCurrent().navigate(MemberForm.class,    //import the object when using navigate
			        		   valueb + "," + value2b +
	 	     	     		  "," + value3b + "," + value4b + "," + idpassed);  //update id exist
			           }
	        		 else	   
	        	 
	             	  {
	        	
	        	    	 Notification notification = Notification.show("Select Member From Grid or fill all fields for new member");
			         		notification.addThemeVariants(NotificationVariant.LUMO_WARNING);
	        	    
	    	              }
	         	         	
	        		 
	         	     
	    	        }
	        );
		     
           buttonAddField.addClickListener(click -> Notification.show("Updating Membership DB",9000,
          		Notification.Position.BOTTOM_START)); 
           
        	buttonAddField.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
	        buttonAddField.addClickListener(click -> form.setEnabled(true));

			buttonAddField2.addThemeVariants(ButtonVariant.LUMO_CONTRAST);
	        		
	        form.setWidthFull();
		    form.setDefaultVerticalComponentAlignment(Alignment.BASELINE);
	        	        	      
	        form.add(firstNameField, lastNameField, phoneNumberField, emailField);
	       
	       
		
	        	        	      	    	        
	        Button buttonToListingField3 = new Button("Members Active", e -> {
	           UI.getCurrent().navigate(PublicReportGrid.class);
	        });
	        
	        
	  
	     Button buttonToListingField4 = new Button("Members Inactive", e -> {
	    	    UI.getCurrent().navigate(MembersPastDue.class);
	      
	        });
	        
	        
	  
	     Button loginreturnButton = new Button("Logout", e -> {
	        	    	                                                                
                                 UI.getCurrent().navigate(MembersLogin.class);


			 }
			);
	        
	       
	         
	       
	        
	        Button buttonClearFields = new Button("Clear Form", e -> { 
	        	 firstNameField.clear();
	        	 lastNameField.clear();
	        	 phoneNumberField.clear();
	        	 emailField.clear();
	        	 buttonAddField.setEnabled(true); //turn back save button after disabling to prevent an add for existing members record
	          }
	        );
	        
	        
		    grid.addSelectionListener(event -> {
		    	  
		      	event.getFirstSelectedItem().ifPresent(MembersBean -> {
		//       	buttonAddField.setEnabled(false); //preventing an add of existing member
		      	binder.readBean(MembersBean);  //populating form
		    	MembersBean idb = MembersBean;  //the id to be used as a join in membersfeesBean 
		        idpassed = idb.getid();
		   
		      	}
		      	
		      			);
		      	}
		    );
	       
	        
	        controls.add(buttonAddField, buttonAddField2, buttonToListingField3,
	        		buttonToListingField4, buttonIndField, buttonClearFields,
				loginreturnButton );

	        controls.setDefaultVerticalComponentAlignment(Alignment.BASELINE);
	        
	  //      grid.addClassName("small-font-grid");
	        
	        add(header, form, controls, grid);}
	


	private void configureGrid() {	        
	
	    	grid.setAllRowsVisible(true);  // so a scroller doesn't appear on grid itself
	 	   grid.addThemeVariants(GridVariant.LUMO_COLUMN_BORDERS);
	        grid.addThemeVariants(GridVariant.LUMO_ROW_STRIPES);
	    	 grid.addThemeVariants(GridVariant.LUMO_COMPACT);
			

	         //   grid.addClassName("small-font-grid");
	        //    grid.addClassName("colored6-grid"); 
	//        grid.addThemeVariants(GridVariant.LUMO_COLUMN_BORDERS);
	 //       grid.addThemeVariants(GridVariant.LUMO_ROW_STRIPES);
	        grid.setSelectionMode(Grid.SelectionMode.SINGLE);
	        
	        grid.setColumns("id", "firstName", "lastName", "phoneNumber", "eMail"); 
	        //the names have to be in lowercase on the entity or a constructor error
	  
	        FooterRow footer = grid.appendFooterRow();
	        FooterCell countFooterCell = footer.getCell(grid.getColumns().get(0));
	        
	        Page<MembersBean> page = membersBeanService.list(PageRequest.of(0,100));
			 List<MembersBean> entityList = page.getContent();
			 grid.setItems(entityList);
			 
	        countFooterCell.setText("Members Since 01/26: " + entityList.size());        	    	        	        
	}
@SuppressWarnings("null")
	
private void configureBinding() {
	binder.forField(emailField)
	.asRequired()	
    .withValidator(new EmailValidator(" " ))
	.bind(MembersBean::geteMail, MembersBean::seteMail);

	binder.forField(firstNameField)
	.asRequired()
	 .withValidator(value -> value != null && value.length() > 0 && value.length() < 26,
		        "Value must be between 1 and 25 characters")			        
	.bind(MembersBean::getfirstName, MembersBean::setfirstName);
	
	binder.forField(lastNameField)
	.asRequired()
	.withValidator(value -> value != null && value.length() > 0 && value.length() < 26,
	        "Value must be between 1 and 25 characters")		
	.bind(MembersBean::getlastName, MembersBean::setlastName);
	
     binder.forField(phoneNumberField)
    .asRequired()
         .withValidator(
              value ->  value.length() == 10,
            "Area Code+Number 10 digits")           
            .bind(MembersBean::getphoneNumber, MembersBean::setphoneNumber);
        
        
 
	}

};



