
package com.example.application.views;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.FooterRow;
import java.time.*;
import com.example.application.entities.MembershipFeesBean; 
import com.example.application.services.MembershipFeesBeanService;
import com.vaadin.flow.component.grid.FooterRow.FooterCell;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//import com.example.examplefeature.MembershipFeesBeanService; -nv used






@PageTitle("MEMBERS EXPIRATION")
@Route("pastduelisting")
@Menu(order = 0, icon = LineAwesomeIconUrl.FILE)

public class MembersPastDue extends VerticalLayout {

    private static final long serialVersionUID = 1L;
    
 Grid<MembershipFeesBean> grid = new Grid<>(MembershipFeesBean.class);
 
 LocalDate currentDate = LocalDate.now();

 HorizontalLayout across = new HorizontalLayout();
	HorizontalLayout across2 = new HorizontalLayout();

 H1 header = new H1("MEMBERS INACTIVE 1 to 7 DAYS");
 
 boolean validmemberfeeExists; 
 boolean latestinactiveAdded;
 
 String holdid;
    
	 

	 
	 private MembershipFeesBeanService membershipFeesBeanService;
	
    
	public MembersPastDue(MembershipFeesBeanService membershipFeesBeanService) {
		this.membershipFeesBeanService = membershipFeesBeanService;
//		grid.addClassName("colored3-grid");
		grid.addClassName("colored4b-grid");
        configureGrid();
  
	}

	@SuppressWarnings("null")

	private void configureGrid() {	
		grid.setAllRowsVisible(true);      // eliminates scrolling within the grid
	
       grid.setHeight(null);
    
        
	   grid.addClassName("colored2-grid");
	                           
	        grid.addThemeVariants(GridVariant.LUMO_COLUMN_BORDERS);
	        grid.addThemeVariants(GridVariant.LUMO_ROW_STRIPES);
	        grid.setColumns("membersId", "fullName", "startDate", "endDate"); 
	    //	grid.setColumns("membersId", "fullName"); 
	    //    grid.setSortableColumns("fullName");
	   //     grid.setColumns("membersId", "startDate", "endDate"); 
	   
	        Page<MembershipFeesBean> page = membershipFeesBeanService.list(PageRequest.of(0,1500));
	        
	    	 List<MembershipFeesBean> entityList = page.getContent(); //converts page to list object
	    	 List<MembershipFeesBean> entityList2 = new ArrayList<>(entityList); //hold of filtered results
	    	 List<MembershipFeesBean> sortedentityList3 = new ArrayList<>();
	    	 
	    	 entityList2.sort(Comparator
	    			    .comparing(MembershipFeesBean::getmembersId)              //by id, and the newest timestampdate to the oldest
	    		    .thenComparing(MembershipFeesBean::getcreatedAt).reversed());
	    	
	
	    	 
          
	    	 for (MembershipFeesBean mb : entityList2 ) {
	    		//  System.out.println("membersId is " + mb.getmembersId());
	    		//  System.out.println("membersEndDate is " + mb.getendDate());
	    		//  System.out.println("creatAt is " + mb.getcreatedAt() );
	    	
	    			 if (mb.getmembersId().equals(holdid)) 
		
	    			 
	    	        	 if (mb.getendDate().isBefore(currentDate.plusDays(0)))
							  if (mb.getendDate().isAfter(currentDate.minusDays(7))) 
						    	  if (! validmemberfeeExists & ! latestinactiveAdded) {
	    	    		//	 if (! validmemberfeeExists)	{   
							//	 System.out.println("latestinactiveAdded flag = " + latestinactiveAdded);   //so not to print if a payment exists and eliminating more than 1				    	           		
	    	    		          sortedentityList3.add(mb);
								// System.out.println("member is " + mb.getmembersId());
								  latestinactiveAdded = true; }
						                 
	    	    			     else;
						      else;
	    	        	 else;
	    	        	     	    	 	 
	    	         else
	    		 
	    		      { holdid = mb.getmembersId();  
					     validmemberfeeExists = false;
					     latestinactiveAdded = false;
					   

	    		      
	    	      	      if (mb.getendDate().isAfter(currentDate.plusDays(0)))  { 
	    		        		  validmemberfeeExists = true;   }
	    		          else
	    		          {
	
	    		        	 if (mb.getendDate().isAfter(currentDate.minusDays(7))) 
							 
	    		      		//  if	 ( mb.getendDate().isBefore(currentDate.plusDays(0))) ...not necessary
							 { 
	    		        			    validmemberfeeExists = false;
						        		 latestinactiveAdded = true;
	    	      	                    sortedentityList3.add(mb);                      }
							//	else;
	    		            
	    		            
	    		                                                                  };
	    		          }
                     }
	 		 
			 grid.setItems(sortedentityList3);
			 
			 System.out.println(" Current date = in MembersPastDue" + currentDate);
			// System.out.println(" Current date minus 7 day = " + currentDate.minusDays(7));
			// System.out.println(" Current date plus 0 day = " + currentDate.plusDays(0));
			// System.out.println(" A 7 day range of past due members, then dropped from list");
			 

	       
	   //     / Add footer with count
	        FooterRow footer = grid.appendFooterRow();
	       FooterCell countFooterCell = footer.getCell(grid.getColumns().get(0));
	     countFooterCell.setText("Total Members: " + sortedentityList3.size());
	     

		  Button buttonToHome = new Button("Home Page", e -> {
	           UI.getCurrent().navigate(GridtobeView.class);
	        });

		 Button buttonToListingField3 = new Button("Members Active", e -> {
	           UI.getCurrent().navigate(PublicReportGrid.class);
	        });
		
         Button loginreturnButton = new Button("Logout", e -> {
	        	    	                                                                
                                 UI.getCurrent().navigate(MembersLogin.class);
			 });
		
		buttonToHome.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		  
		  across.add(grid);
		  across2.add(buttonToHome, buttonToListingField3, loginreturnButton);

		  across.setWidthFull();
		

	     // add(header, across, buttonToHome, buttonToListingField3);   
		  add(header, across, across2);  
	        		
	}

}
	

 
