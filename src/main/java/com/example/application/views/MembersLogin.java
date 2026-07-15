package com.example.application.views;

import org.vaadin.lineawesome.LineAwesomeIconUrl;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
//import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.*;
//import java.util.Arrays;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.Route;

@Route("")
//@PageTitle("loginpage")
@Menu(order = 0, icon = LineAwesomeIconUrl.FILE)

public class MembersLogin  extends VerticalLayout {
             TextField pwField = new TextField();
             Button confirmedButton = new Button();

            // int [] passwords = {895632, 254783, 378609};
              H1 header = new H1("DEMO 2 Administration Login Page ");
            //  boolean authorized = false;

             public MembersLogin() {
            //  System.out.println("In the MembersLogin constructor");
        
            
                        pwField.setLabel("-------------PASSWORD-------------");
                        pwField.setValue(""); 
                        pwField.getStyle().set("--vaadin-input-field-border-width", "3px");
                    //    add(header, pwField, confirmedButton);

                        Button confirmedButton = new Button("Confirm", e -> {
	        	        
	                      var pwvalue = pwField.getValue();

                         if (pwvalue.length() > 0) {
                            if (pwvalue.equals("mylife") ||
                                pwvalue.equals("urlife") ||
                                   pwvalue.equals("thelife"))    
							         System.out.println("Login Id = " + pwvalue);
                                     UI.getCurrent().navigate(GridtobeView.class);
						     }
                            else
                            {
                               System.out.println("Not Authorized User");   
	         		           Notification notification = Notification.show("Not Authorized User");
	         		           notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
                            }
				
					//		{
                    //        }
                        });
                     
                        
        	               confirmedButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
                        setAlignItems(FlexComponent.Alignment.CENTER);

                        add(header, pwField, confirmedButton);
                    } ;         
            };
        
      


