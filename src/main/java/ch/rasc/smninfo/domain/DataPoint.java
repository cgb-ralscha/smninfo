package ch.rasc.smninfo.domain;

import com.univocity.parsers.annotations.Convert;
import com.univocity.parsers.annotations.NullString;
import com.univocity.parsers.annotations.Parsed;

import ch.rasc.smninfo.util.EpochSecondsConversion;
import ch.rasc.smninfo.xodus.ExodusManager;
import jetbrains.exodus.entitystore.Entity;

public class DataPoint {

//	gre000z0
//	tde200s0	
//	ppz850s0
//	ppz700s0
//	dv1towz0
//	fu3towz0
//	fu3towz1
//	ta1tows0
//	uretows0
//	tdetows0
	
	@Parsed(field = "stn")
	private String code;

	@Parsed(field = "time")
	@Convert(conversionClass = EpochSecondsConversion.class)
	private long epochSeconds;

	/**
	 * °C: Air temperature 2 m above ground; current value
	 */
	@Parsed(field = "tre200s0")
	@NullString(nulls = "-")
	private Double temperature;

	/**
	 * min: Sunshine duration; ten minutes total
	 */
	@Parsed(field = "sre000z0")
	@NullString(nulls = "-")
	private Integer sunshine;

	/**
	 * mm: Precipitation; ten minutes total
	 */
	@Parsed(field = "rre150z0")
	@NullString(nulls = "-")
	private Double precipitation;

	/**
	 * °: Wind direction; ten minutes mean
	 */
	@Parsed(field = "dkl010z0")
	@NullString(nulls = "-")
	private Integer windDirection;

	/**
	 * km/h: Wind speed; ten minutes mean
	 */
	@Parsed(field = "fu3010z0")
	@NullString(nulls = "-")
	private Double windSpeed;

	/**
	 * hPa: Pressure reduced to sea level according to standard atmosphere (QNH); current
	 * value
	 */
	@Parsed(field = "pp0qnhs0")
	@NullString(nulls = "-")
	private Double qnhPressure;

	/**
	 * km/h: Gust peak (one second); maximum
	 */
	@Parsed(field = "fu3010z1")
	@NullString(nulls = "-")
	private Double gustPeak;

	/**
	 * %: Relative air humidity 2 m above ground; current value
	 */
	@Parsed(field = "ure200s0")
	@NullString(nulls = "-")
	private Integer humidity;

	/**
	 * hPa: Pressure at station level (QFE); current value
	 */
	@Parsed(field = "prestas0")
	@NullString(nulls = "-")
	private Double qfePressure;

	/**
	 * hPa: Pressure reduced to sea level (QFF); current value
	 */
	@Parsed(field = "pp0qffs0")
	@NullString(nulls = "-")
	private Double qffPressure;

	public DataPoint() {
		// default constructor
	}

	public DataPoint(Entity e) {
		this.code = getProperty(e, ExodusManager.CODE);
		this.epochSeconds = getProperty(e, ExodusManager.EPOCH_SECONDS);
		this.temperature = getProperty(e, "temperature");
		this.sunshine = getProperty(e, "sunshine");
		this.precipitation = getProperty(e, "precipitation");
		this.windDirection = getProperty(e, "windDirection");
		this.windSpeed = getProperty(e, "windSpeed");
		this.qnhPressure = getProperty(e, "qnhPressure");
		this.gustPeak = getProperty(e, "gustPeak");
		this.humidity = getProperty(e, "humidity");
		this.qfePressure = getProperty(e, "qfePressure");
		this.qffPressure = getProperty(e, "qffPressure");
	}

	private static <T> T getProperty(Entity e, String propertyName) {
		return (T) e.getProperty(propertyName);
	}

	public void toEntity(Entity e) {
		e.setProperty(ExodusManager.CODE, getCode());
		e.setProperty(ExodusManager.EPOCH_SECONDS, getEpochSeconds());

		if (getTemperature() != null) {
			e.setProperty("temperature", getTemperature());
		}

		if (getSunshine() != null) {
			e.setProperty("sunshine", getSunshine());
		}

		if (getPrecipitation() != null) {
			e.setProperty("precipitation", getPrecipitation());
		}

		if (getWindDirection() != null) {
			e.setProperty("windDirection", getWindDirection());
		}

		if (getWindSpeed() != null) {
			e.setProperty("windSpeed", getWindSpeed());
		}

		if (getQnhPressure() != null) {
			e.setProperty("qnhPressure", getQnhPressure());
		}

		if (getGustPeak() != null) {
			e.setProperty("gustPeak", getGustPeak());
		}

		if (getHumidity() != null) {
			e.setProperty("humidity", getHumidity());
		}

		if (getQfePressure() != null) {
			e.setProperty("qfePressure", getQfePressure());
		}

		if (getQffPressure() != null) {
			e.setProperty("qffPressure", getQffPressure());
		}
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public long getEpochSeconds() {
		return this.epochSeconds;
	}

	public void setEpochSeconds(long epochSeconds) {
		this.epochSeconds = epochSeconds;
	}

	public Double getTemperature() {
		return this.temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	public Integer getSunshine() {
		return this.sunshine;
	}

	public void setSunshine(Integer sunshine) {
		this.sunshine = sunshine;
	}

	public Double getPrecipitation() {
		return this.precipitation;
	}

	public void setPrecipitation(Double precipitation) {
		this.precipitation = precipitation;
	}

	public Integer getWindDirection() {
		return this.windDirection;
	}

	public void setWindDirection(Integer windDirection) {
		this.windDirection = windDirection;
	}

	public Double getWindSpeed() {
		return this.windSpeed;
	}

	public void setWindSpeed(Double windSpeed) {
		this.windSpeed = windSpeed;
	}

	public Double getQnhPressure() {
		return this.qnhPressure;
	}

	public void setQnhPressure(Double qnhPressure) {
		this.qnhPressure = qnhPressure;
	}

	public Double getGustPeak() {
		return this.gustPeak;
	}

	public void setGustPeak(Double gustPeak) {
		this.gustPeak = gustPeak;
	}

	public Integer getHumidity() {
		return this.humidity;
	}

	public void setHumidity(Integer humidity) {
		this.humidity = humidity;
	}

	public Double getQfePressure() {
		return this.qfePressure;
	}

	public void setQfePressure(Double qfePressure) {
		this.qfePressure = qfePressure;
	}

	public Double getQffPressure() {
		return this.qffPressure;
	}

	public void setQffPressure(Double qffPressure) {
		this.qffPressure = qffPressure;
	}

	@Override
	public String toString() {
		return "DataPoint [code=" + this.code + ", epochSeconds=" + this.epochSeconds
				+ ", temperature=" + this.temperature + ", sunshine=" + this.sunshine
				+ ", precipitation=" + this.precipitation + ", windDirection="
				+ this.windDirection + ", windSpeed=" + this.windSpeed + ", qnhPressure="
				+ this.qnhPressure + ", gustPeak=" + this.gustPeak + ", humidity="
				+ this.humidity + ", qfePressure=" + this.qfePressure + ", qffPressure="
				+ this.qffPressure + "]";
	}

}
