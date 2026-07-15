package com.example.application.views;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.FooterRow;
import java.time.*;
//import com.example.application.views.MembershipFeesBean; 
import com.vaadin.flow.component.grid.FooterRow.FooterCell;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
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
import java.util.List;

import com.example.application.services.MembershipFeesBeanService; 
import com.example.application.entities.MembershipFeesBean;






@PageTitle("ACTIVE MEMBERS REPORT")
@Route("listing")
@Menu(order = 0, icon = LineAwesomeIconUrl.FILE)

public class PublicReportGrid extends VerticalLayout {

    private static final long serialVersionUID = 1L;
    
 Grid<MembershipFeesBean> grid = new Grid<>(MembershipFeesBean.class);
 
 LocalDate currentDate = LocalDate.now();

 H1 header = new H1("Lee's Active Members");

	HorizontalLayout across = new HorizontalLayout();
    
	 
	// private final MembershipFeesBeanService membershipFeesBeanService;
	 
	 private MembershipFeesBeanService membershipFeesBeanService;
	
    
	public PublicReportGrid(MembershipFeesBeanService membershipFeesBeanService) {
		this.membershipFeesBeanService = membershipFeesBeanService;
//		grid.addClassName("colored3-grid");
		grid.addClassName("colored4b-grid");
	//	System.out.println(" Current date = " + currentDate);
        configureGrid();
  
	}

	
	private void configureGrid() {	
		grid.setAllRowsVisible(true);      // eliminates scrolling within the grid
	
       grid.setHeight(null);
    
        
	   grid.addClassName("colored2-grid");
	                           
	        grid.addThemeVariants(GridVariant.LUMO_COLUMN_BORDERS);
	        grid.addThemeVariants(GridVariant.LUMO_ROW_STRIPES);
	        grid.setColumns("membersId", "fullName", "startDate", "endDate"); 
	   //     grid.setSortableColumns("fullName");
	   //     grid.setColumns("membersId", "startDate", "endDate"); 
	   
	        Page<MembershipFeesBean> page = membershipFeesBeanService.list(PageRequest.of(0,1500));
	    	 List<MembershipFeesBean> entityList = page.getContent(); //converts page to list object
	    	 List<MembershipFeesBean> entityList2 = new ArrayList<>(); //hold of filtered results
          
	    	 for (MembershipFeesBean mb : entityList ) {
            	 if (mb.getendDate().isAfter(currentDate.minusDays(0)))
            		 entityList2.add(mb);
             }
			 grid.setItems(entityList2);
			 
		//	 System.out.println(" Current date = " + currentDate);
		//	 System.out.println(" Current date minus 1 day = " + currentDate.minusDays(1));
			 
			 
			
					 
			
	        	        	       
	       
	   //     / Add footer with count
	        FooterRow footer = grid.appendFooterRow();
	        FooterCell countFooterCell = footer.getCell(grid.getColumns().get(0));
	        countFooterCell.setText("Total Members: " + entityList2.size());

			Button buttonToHome = new Button("Home Page", e -> {
	           UI.getCurrent().navigate(GridtobeView.class);
	        });
            buttonToHome.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		
	    	Button buttonToListingField4 = new Button("Members Inactive", e -> {
	    	    UI.getCurrent().navigate(MembersPastDue.class);
	      
	        });
	   

			   across.add(buttonToHome, buttonToListingField4);
			
				add(header, grid, across);
	    
	
	                                   
	        		
	}	

}
