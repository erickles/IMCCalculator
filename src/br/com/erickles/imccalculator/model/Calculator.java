package br.com.erickles.imccalculator.model;

import android.content.Context;
import br.com.erickles.imccalculator.R;

public class Calculator {

	/**
	 * Retorna o calculo do IMC
	 * @param weight	Peso da pessoa
	 * @param heigth	Altura da pessoa
	 * @return			O IMC calculado
	 */
	public static double calculateIMC(double weight, double heigth){
		return weight / (heigth * heigth);
	}	
	
	/**
	 * Retorna o indice de massa corporea
	 * @param imc		O IMC calculado
	 * @param context	Objeto context da aplicacao
	 * @return			A situacao da massa corporea
	 */
	public static String getSituationBodyMass(double imc, Context context){
		
		if(imc < 17){
			return context.getString(R.string.VeryUnderweight);
		}else{
			if(imc >= 17 && imc <= 18.49){
				return context.getString(R.string.UnderWeight);
			}else{
				if(imc >= 18.50 && imc <= 24.99){
					return context.getString(R.string.NormalWeight);
				}else{
					if(imc >= 25 && imc <= 29.99){
						return context.getString(R.string.Overweight);
					}else{
						if(imc >= 30 && imc <= 34.99){
							return context.getString(R.string.ObesityI);
						}else{
							if(imc >= 35 && imc <= 39.99){
								return context.getString(R.string.ObesityII);
							}else{
								return context.getString(R.string.ObesityIII);
							}
						}
					}
				}
			}
		}
	}
	
	public static double weightToBeLost(double imc,double weight){
		return 0;
	}
	
}
