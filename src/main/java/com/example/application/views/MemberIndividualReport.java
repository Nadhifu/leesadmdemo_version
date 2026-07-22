
package com.example.application.views; 

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
//import com.vaadin.flow.component.UI;
//import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.FooterRow;
import java.time.*;
//import com.example.application.views.MembershipFeesBean;
import com.vaadin.flow.component.grid.FooterRow.FooterCell;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
//import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

import java.util.ArrayList;
import java.util.List;


import com.example.application.entities.*;
import com.example.application.services.*;






@PageTitle("MEMBER Activity")
@Route("memberlisting")
@Menu(order = 0, icon = LineAwesomeIconUrl.FILE)

public class MemberIndividualReport extends VerticalLayout implements HasUrlParameter<String>
{
	TextField firstNameField = new TextField("First Name");
	TextField lastNameField = new TextField( "Last Name");
	TextField id = new TextField("id");
	 String membersjoin;
	 H1 header = new H1("Demo Member Payment Reporting ");
	 HorizontalLayout across = new HorizontalLayout();

    private static final long serialVersionUID = 1L;
    
 Grid<MembershipFeesBean> grid = new Grid<>(MembershipFeesBean.class);
 
 LocalDate currentDate = LocalDate.now();
    
	 
	 
	 private MembershipFeesBeanService membershipFeesBeanService;
	
    
	public MemberIndividualReport(MembershipFeesBeanService membershipFeesBeanService) {
		this.membershipFeesBeanService = membershipFeesBeanService;
//		grid.addClassName("colored3-grid");
	//	grid.addClassName("colored4b-grid");
		grid.setAllRowsVisible(true);      // eliminates scrolling within the grid
		
	       grid.setHeight(null);
		
		   grid.setWidth("50");
		
	      
	    
	        
		//   grid.addClassName("colored2-grid");
		                           
		        grid.addThemeVariants(GridVariant.LUMO_COLUMN_BORDERS);
		        grid.addThemeVariants(GridVariant.LUMO_ROW_STRIPES);
		       
		    
	//	System.out.println(" Current date = " + currentDate);
        
        
        
  
	}
	
	@Override
	public void setParameter(BeforeEvent event, String pN) {
        // Use the parameter
       String paramValue = pN;
   
   
       String data = paramValue;
      System.out.println("Passed into MemberIndividualReport" + pN);
       
    //   System.out.println("paramValue =  " + paramValue);
       /*  
        * Passed data is a string of fields separated by "," comma, the split methods scans the string
        * and separates by "," each is placed in a string array and then select by subscript
        *  **/
       
       String[] items = data.split(","); // Splits at each comma
     
       var membersjoin = items[3];
 //       membersjoin = items[3];   //members join of membersfees
       
       
       FormLayout form = new FormLayout();
   // 	form.addClassName("colored2-layout");
    
    	 
	  //      form.setSizeFull();
  //     VerticalLayout vl = new VerticalLayout();
     
   //    firstNameField.addClassName("colored6-grid");
    //	  firstNameField.getStyle()
    //      .set("background-color", "#fde3f6ff");
      
       firstNameField.setValue(items[1]);
       firstNameField.setReadOnly(true);
      
       
    //   lastNameField.addClassName("colored6-grid");
    //   lastNameField.getStyle()
    //   .set("background-color", " #fde3f6ff");
   
       lastNameField.setValue(items[2]);
       lastNameField.setReadOnly(true);

     //  id.getStyle()
     //  .set("background-color", "#fde3f6ff");
       
       id.setValue(items[3]);
       id.setLabel("Identification");    
       id.setReadOnly(true);

	   Button returntohome = new Button("Home Page", e -> {
	           UI.getCurrent().navigate(GridtobeView.class);
	        });
		Button returntoactive = new Button("Members Active", e -> {
	           UI.getCurrent().navigate(PublicReportGrid.class);
	        });

		Button returntoinactive = new Button("Members Inactive", e -> {
	           UI.getCurrent().navigate(MembersPastDue.class);
	        });

	
        returntohome.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
   
    //  form.setMaxWidth("200px");
       form.add(firstNameField, lastNameField, id, returntohome, returntoactive, returntoinactive);
    
     
       
       
   //    configureForm();
       configureGrid();
       
       Page<MembershipFeesBean> page = membershipFeesBeanService.list(PageRequest.of(0,1000));
  	 List<MembershipFeesBean> entityList = page.getContent(); //converts page to list object
  	 List<MembershipFeesBean> entityList2 = new ArrayList<>(); //hold of filtered results
       
  	 for (MembershipFeesBean mb : entityList ) {
    // 	 System.out.println("Member Id " + mb.getmembersId());
   	//	 System.out.println("membersjoin " + membersjoin);
      	 if (mb.getmembersId().equals(membersjoin))     
      			 entityList2.add(mb);
      		// System.out.println("Member Id " + mb.getmembersId());
      		// System.out.println("membersjoin " + membersjoin);
       };
	     form.getStyle().set("--vaadin-input-field-border-width", "3px");
		 
	     grid.setWidthFull();
		 grid.setItems(entityList2);
		    
		   //     / Add footer with count
		        FooterRow footer = grid.appendFooterRow();
		        FooterCell countFooterCell = footer.getCell(grid.getColumns().get(0));
		        countFooterCell.setText("Total Payments: " + entityList2.size());
		 
		        across.setWidthFull();
			//	grid.setWidthFull();

		    	form.setWidth("250px");
			
			
				across.add(form, grid);

		        add(header, across);
       
      
  
	


     
   }    
	

	
	private void configureGrid() {	
		grid.setAllRowsVisible(true);      // eliminates scrolling within the grid
	
       grid.setHeight(null);
       
  
       
       grid.setPageSize(200); // Increase page size to show more items
    
        
	   grid.addClassName("colored2-grid");
	                           
	        grid.addThemeVariants(GridVariant.LUMO_COLUMN_BORDERS);
	        grid.addThemeVariants(GridVariant.LUMO_ROW_STRIPES);
	   //     grid.setColumns("membersId", "fullName", "amount", "startDate", "endDate", "createdAt"); 
	    //      id.setLabel("Identification");
	   //     grid.setColumns("membersId", "startDate", "endDate"); 
	            grid.setColumns("id", "amount", "startDate", "endDate", "paymentType", "createdAt");
	            id.setLabel("Identification");
    		
	}	

}
