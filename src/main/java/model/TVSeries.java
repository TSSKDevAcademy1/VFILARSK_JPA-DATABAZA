package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("S")
public class TVSeries extends VideoArt {

	@Override
	public String toString() {
		return "TVSeries [seriesCount=" + seriesCount + ", episodeCount=" + episodeCount + ", startYear=" + startYear
				+ ", endYear=" + endYear + "]";
	}

	private int seriesCount;
	private int episodeCount;
	private int startYear;
	private int endYear;

	public int getSeriesCount() {
		return seriesCount;
	}

	public void setSeriesCount(int seriesCount) {
		this.seriesCount = seriesCount;
	}

	public int getEpisodeCount() {
		return episodeCount;
	}

	public void setEpisodeCount(int episodeCount) {
		this.episodeCount = episodeCount;
	}

	public int getStartYear() {
		return startYear;
	}

	public void setStartYear(int startYear) {
		this.startYear = startYear;
	}

	public int getEndYear() {
		return endYear;
	}

	public void setEndYear(int endYear) {
		this.endYear = endYear;
	}
}
