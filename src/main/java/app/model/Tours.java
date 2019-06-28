package app.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name="tours")
public class Tours{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer tourId;
	
	@Column(name="title")
	private String tourTitle;
	
	@Column(name="description")
	private String tourDescription;
	
	@Column(name="status")
	private Integer tourStatus;
	
	@Column(name="image")
	private String tourImage;
	
	@Column(name="price")
	private Integer tourPrice;
	
	
	@ManyToOne
	  @JoinColumn(name = "id_from", nullable = false)
	private Places from;
//	@Column(name="id_from")
//	private Integer tourIdFrom;
	
//	@Column(name="id_destination")
//	private Integer tourIdDestination;
//	@ManyToOne(targetEntity = Places.class)
//	@JoinColumn(name="id_destination")
	@ManyToOne
	  @JoinColumn(name = "id_destination", nullable = false)
	private Places destination;
	
	
	@Column(name="car_id")
	private Integer tourIdCar;

	@Column(name="rating")
	private Integer tourRating;

	
	public Integer getTourPrice() {
		return tourPrice;
	}

	public void setTourPrice(Integer tourPrice) {
		this.tourPrice = tourPrice;
	}

	public Places getFrom() {
		return from;
	}

	public void setFrom(Places from) {
		this.from = from;
	}

	public Places getDestination() {
		return destination;
	}

	public void setDestination(Places destination) {
		this.destination = destination;
	}
	
	
	public Integer getTourRating() {
		return tourRating;
	}

	public void setTourRating(Integer tourRating) {
		this.tourRating = tourRating;
	}

	public Integer getTourId() {
		return tourId;
	}

	public void setTourId(Integer tourId) {
		this.tourId = tourId;
	}

	public String getTourTitle() {
		return tourTitle;
	}

	public void setTourTitle(String tourTitle) {
		this.tourTitle = tourTitle;
	}

	public String getTourDescription() {
		return tourDescription;
	}

	public void setTourDescription(String tourDescription) {
		this.tourDescription = tourDescription;
	}

	public Integer getTourStatus() {
		return tourStatus;
	}

	public void setTourStatus(Integer tourStatus) {
		this.tourStatus = tourStatus;
	}

	public String getTourImage() {
		return tourImage;
	}

	public void setTourImage(String tourImage) {
		this.tourImage = tourImage;
	}

//	public Integer getTourIdFrom() {
//		return tourIdFrom;
//	}
//
//	public void setTourIdFrom(Integer tourIdFrom) {
//		this.tourIdFrom = tourIdFrom;
//	}

	
//	public Integer getTourIdDestination() {
//		return tourIdDestination;
//	}
//
//	public void setTourIdDestination(Integer tourIdDestination) {
//		this.tourIdDestination = tourIdDestination;
//	}

	public Integer getTourIdCar() {
		return tourIdCar;
	}

	public void setTourIdCar(Integer tourIdCar) {
		this.tourIdCar = tourIdCar;
	}
	
	
	
	
	
	
}



//package app.model;
//
//
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Table;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
//
//@Entity
//@Table(name="tours")
//public class Tours{
//	
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	@Column(name="id")
//	private Integer tourId;
//	
//	@Column(name="title")
//	private String tourTitle;
//	
//	@Column(name="description")
//	private String tourDescription;
//	
//	@Column(name="status")
//	private Integer tourStatus;
//	
//	@Column(name="image")
//	private String tourImage;
//	
//	@Column(name="id_from")
//	private Integer tourIdFrom;
//	
////	@Column(name="id_from")
////	private String tourFrom;
////	
////	@ManyToOne(targetEntity = Places.class)
////	@JoinColumn(name="id_destination")
////	private Places places;
//	@Column(name="id_destination")
//	private Integer tourIdDestination;
//	
////	@Column(name="id_destination")
////	private String tourDestination;
//
//	@Column(name="tourIdCar")
//	private Integer tourIdCar;
//
//	
////	public String getTourFrom() {
////		return tourFrom;
////	}
////
////
////	public void setTourFrom(String tourFrom) {
////		this.tourFrom = tourFrom;
////	}
////
////
////	public String getTourDestination() {
////		return tourDestination;
////	}
////
////
////	public void setTourDestination(String tourDestination) {
////		this.tourDestination = tourDestination;
////	}
//
//
//	public Integer getTourIdDestination() {
//		return tourIdDestination;
//	}
//
//
//	public void setTourIdDestination(Integer tourIdDestination) {
//		this.tourIdDestination = tourIdDestination;
//	}
//
//
//	public Integer getTourId() {
//		return tourId;
//	}
//
//
//	public void setTourId(Integer tourId) {
//		this.tourId = tourId;
//	}
//
//
//	public String getTourTitle() {
//		return tourTitle;
//	}
//
//
//	public void setTourTitle(String tourTitle) {
//		this.tourTitle = tourTitle;
//	}
//
//
//	public String getTourDescription() {
//		return tourDescription;
//	}
//
//
//	public void setTourDescription(String tourDescription) {
//		this.tourDescription = tourDescription;
//	}
//
//
//	public Integer getTourStatus() {
//		return tourStatus;
//	}
//
//
//	public void setTourStatus(Integer tourStatus) {
//		this.tourStatus = tourStatus;
//	}
//
//
//	public String getTourImage() {
//		return tourImage;
//	}
//
//
//	public void setTourImage(String tourImage) {
//		this.tourImage = tourImage;
//	}
//
//
//	public Integer getTourIdFrom() {
//		return tourIdFrom;
//	}
//
//
//	public void setTourIdFrom(Integer tourIdFrom) {
//		this.tourIdFrom = tourIdFrom;
//	}
//
//
////	public Places getPlaces() {
////		return places;
////	}
////
////
////	public void setPlaces(Places places) {
////		this.places = places;
////	}
//
//
//	public Integer getTourIdCar() {
//		return tourIdCar;
//	}
//
//
//	public void setTourIdCar(Integer tourIdCar) {
//		this.tourIdCar = tourIdCar;
//	}
//
//	
//	
//	
//	
//	
//}
