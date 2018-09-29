package edu.esprit.allfordeal.handler;

import edu.esprit.allfordeal.dao.ClientDao;
import edu.esprit.allfordeal.dao.ProduitDao;
import edu.esprit.allfordeal.entities.Reservation;
import java.util.Date;
import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


/**
 *
 * @author Saif Eddine
 */
public class ReservationHandler extends DefaultHandler{
   private Vector reservationVector;

    public ReservationHandler() {
        reservationVector = new Vector();
    }
   public Reservation[] getReservations() {
        Reservation[] reservationTab = new Reservation[reservationVector.size()];
        reservationVector.copyInto(reservationTab);
        return reservationTab;
    }
    private Reservation currentReservation;
   public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("reservation")) {

            int id_reservation = Integer.parseInt(attributes.getValue("id_reservation"));
            String date_fin_reservation = attributes.getValue("date_fin_reservation");
            int id_produit = Integer.parseInt(attributes.getValue("id_produit"));
            int id_client = Integer.parseInt(attributes.getValue("id_client"));
            
            ClientDao cd = new ClientDao();
            ProduitDao pd = new ProduitDao();
                        
            currentReservation = new Reservation(id_reservation, date_fin_reservation, pd.findById(id_produit),  cd.findById(id_client));

        }
    }
   public void endElement(String url,String localName,String qName)throws SAXException{
       if(qName.equals("reservation")){
           reservationVector.addElement(currentReservation);
           currentReservation=null;
       }
   }
   
}
