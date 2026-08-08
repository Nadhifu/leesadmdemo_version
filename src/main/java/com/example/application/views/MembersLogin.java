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
import com.vaadin.flow.component.html.Image;



@Route("")
//@PageTitle("loginpage")
@Menu(order = 0, icon = LineAwesomeIconUrl.FILE)

public class MembersLogin  extends VerticalLayout {
             TextField pwField = new TextField();
             Button confirmedButton = new Button();

            // int [] passwords = {895632, 254783, 378609};
              H1 header = new H1("Demo Administration Login Page ");
	                                                                                          
	
	   //testt
	   

            //  boolean authorized = false;

             public MembersLogin() {
            //  System.out.println("In the MembersLogin constructor");
        
                        header.getStyle().set("font-size", "50px");
				        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
                        setJustifyContentMode(JustifyContentMode.CENTER);
                        pwField.setLabel("    PASSWORD     ");
                        pwField.setValue(""); 
                        pwField.getStyle().set("--vaadin-input-field-border-width", "5px");
                       Image img = new Image("/clientmessage.png", "Express PNG");
			/**	        Paragraph paragraph1 = new Paragraph(
            "This is a static paragraph displayed in Vaadin dedicated to provided."
                     );
				 	     Paragraph paragraph2 = new Paragraph(
            "This is # 2 a static paragraph displayed in Vaadin."
                     );

				 	     Paragraph paragraph3 = new Paragraph(
            "This is #3 a static paragraph displayed in Vaadin." */
              //       );
                    //    add(header, pwField, confirmedButton);

                        Button confirmedButton = new Button("Confirm", e -> {
							
	        	        
	                      var pwvalue = pwField.getValue();
							 System.out.println("Password entered: " + pwvalue);

                  if (pwvalue != null && pwvalue.length() > 0) {
                          if (pwvalue.equals("mylife") || pwvalue.equals("123") || pwvalue.equals("thelife")) {
                             UI.getCurrent().navigate(GridtobeView.class);
                          } else {
							  System.out.println("Password entered failed: " + pwvalue);
                                 Notification notification = Notification.show("Not Authorized User");
                                 notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
                                }
                    } else
			        	 {
                         Notification notification = Notification.show("Please enter a password");
                         notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
                         }
              });
 
                     
                    
        	               confirmedButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
			        	 confirmedButton.getStyle().set("background-color", "green");
                        setAlignItems(FlexComponent.Alignment.CENTER);

				/**		paragraph1.getStyle()
                             .set("font-size", "16px")
                             .set("color", "#333");	

						paragraph2.getStyle()
                             .set("font-size", "16px")
                             .set("color", "#233");		

					 	paragraph3.getStyle()
                             .set("font-size", "16px")
                             .set("color", "#133");	 */
			

        // Check parameters before adding to UI
      /** if (img.getSrc() == null || img.getSrc().isEmpty()) {
            Notification.show("Image source is missing!");
        } else {
            Notification.show("Image source set to: " + img.getSrc());
        }

        if (img.getAlt() == null || img.getAlt().isEmpty()) {
            Notification.show("Alt text is missing!");
        }  */

        

				
 
                        add(header, pwField, confirmedButton, img);
                            
            }};


