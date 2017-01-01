/*
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */
public class TemperatureConversion
{
 
 // Indices
 public static final double 
 INDEX_F= 32,
 INDEX_K= 273.15,
 INDEX_RA = 459.67;

 public static double celciusTO(Temperature temp, double c){
	switch (temp){
	 case FAHRENHEIT:
		return (c * 9 / 5) + INDEX_F;
	 case KELVIN:
		return c + INDEX_K;
	 case RANKINE:
		return (c * 1.8) + INDEX_F + INDEX_RA;
	 case REAUMUR:
		return c * 0.8;
	 default:
		return c;
	}
 }

 public static double fahrenheitTO(Temperature temp, double f){
	switch (temp){
	 case CELCIUS:
		return (f - INDEX_F) * 5 / 9;
	 case KELVIN:
		return fahrenheitTO(Temperature.CELCIUS, f) + INDEX_K;
	 case RANKINE:
		return f + INDEX_RA;
	 case REAUMUR:
		return (f - INDEX_F) / 2.25;
	 default:
		return f;
	}
 }

 public static double kelvinTO(Temperature temp, double k){
	switch (temp){
	 case CELCIUS:
		return k - INDEX_K;
	 case FAHRENHEIT:
		return (kelvinTO(Temperature.CELCIUS, k) * 9 / 5) + INDEX_K;
	 case RANKINE:
		return k * 1.8;
	 case REAUMUR:
		return kelvinTO(Temperature.CELCIUS, k) * 0.8;
	 default:
		return k;
	}
 }

 public static double rankineTO(Temperature temp, double ra){
	switch (temp){
	 case CELCIUS:
		return (rankineTO(Temperature.FAHRENHEIT, ra) - INDEX_F) / 1.8;
	 case FAHRENHEIT:
		return ra - INDEX_RA;
	 case KELVIN:
		return ra / 1.8;
	 case REAUMUR:
		return (rankineTO(Temperature.FAHRENHEIT, ra) - INDEX_F) / 2.25;
	 default:
		return ra;
	}
 }

 public static double reaumurTO(Temperature temp, double re){
	switch (temp){
	 case CELCIUS:
		return re * 1.25;
	 case FAHRENHEIT:
		return (re * 2.25) + INDEX_F;
	 case KELVIN:
		return reaumurTO(Temperature.CELCIUS, re) + INDEX_K;
	 case RANKINE:
		return reaumurTO(Temperature.FAHRENHEIT, re) + INDEX_RA;
	 default:
		return re;
	}
 }

 public static double convert(Temperature from, Temperature to, double degree){
	switch (from){
	 case CELCIUS: return celciusTO(to, degree);
	 case FAHRENHEIT: return fahrenheitTO(to, degree);
	 case KELVIN: return kelvinTO(to, degree);
	 case RANKINE: return rankineTO(to, degree);
	 case REAUMUR: return reaumurTO(to, degree);
	 default: return celciusTO(to, degree);
	}
 }
}
