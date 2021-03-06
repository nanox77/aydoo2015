package ar.edu.tp1.domain.promotion;

import java.util.Date;
import java.util.Set;

import ar.edu.tp1.domain.attraction.Attraction;
import ar.edu.tp1.domain.attraction.Suggestion;

public class AbsolutePromotion implements Promotable {

	private Set<Attraction> attractions;
	private Date startDate;
	private Date endDate;
	private Float costTotal;

	public AbsolutePromotion(Date startDate, Date endDate, Set<Attraction> attractions, Float costTotal) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.attractions = attractions;
		this.costTotal = costTotal;
	}

	@Override
	public Float calculateCost(Suggestion suggestion) {
		Float costTotal = suggestion.calculateCostTotalForAttractions();
		if (isActive() && isAppliedPromotion(suggestion)) {
			return costTotal - this.costTotal;
		}
		return costTotal;
	}

	private boolean isAppliedPromotion(Suggestion suggestion) {
		return this.attractions.containsAll(suggestion.getAttractionsSuggested());
	}

	private boolean isActive() {
		Date today = new Date();
		return today.after(this.startDate) && today.before(this.endDate);
	}

	@Override
	public Boolean isCombinable() {
		return Boolean.TRUE;
	}
}