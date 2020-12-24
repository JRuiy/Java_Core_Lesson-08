package ua.lviv.logos;

import java.util.Scanner;

public class Aplication {

	enum Seasons {
		WINTER, SPRING, SUMMER, FALL;
	}

	enum Month {
		JANUARY(31, Seasons.WINTER), FEBRUARY(28, Seasons.WINTER), MARCH(31, Seasons.SPRING), APRIL(30, Seasons.SPRING),
		MAY(31, Seasons.SPRING), JUNE(30, Seasons.SUMMER), JULY(31, Seasons.SUMMER), AUGUST(31, Seasons.SUMMER),
		SEPTEMBER(30, Seasons.FALL), OCTOBER(31, Seasons.FALL), NOVEMBER(30, Seasons.FALL), DECEMBER(31, Seasons.WINTER);

		int days;
		Seasons seasons;

		private Month(int days, Seasons seasons) {
			this.days = days;
			this.seasons = seasons;
		}

		public int getDays() {
			return days;
		}

		public Seasons getSeasons() {
			return seasons;
		}
	}

	static void menu() {
		System.out.println("Натисніть 1 для того, щоб перевірити чи є такий місяць");
		System.out.println("Натисніть 2 для того, щоб показати місяці цієї пори року");
		System.out.println("Натисніть 3 для того, щоб показати які місяці мають таку ж кількість днів");
		System.out.println("Натисніть 4 для того, щоб показати які місяці мають меншу кількість днів");
		System.out.println("Натисніть 5 для того, щоб показати які місяці мають більшу кількість днів");
		System.out.println("Натисніть 6 для того, щоб показати наступну пору року");
		System.out.println("Натисніть 7 для того, щоб показати попередню пору року");
		System.out.println("Натисніть 8 для того, щоб показати, які місяці мають парну кількість днів");
		System.out.println("Натисніть 9 для того, щоб показати, які місяці мають непарну кількість днів");
		System.out.println("Натисніть 10 для того, щоб показати чи вказаний місяць має парну кількість днів");
	}

	public static void main(String[] args) {

		Seasons [] sea = Seasons.values();
		Month[] mas = Month.values();
		Scanner sc = new Scanner(System.in);

		while (true) {
			menu();

			switch (sc.next()) {
			case "1": {
				System.out.println("Введіть місяць: ");
				sc = new Scanner(System.in);
				String month = sc.next().toUpperCase();

				boolean flag = isMonthPresent(mas, month);

				if (!flag) {
					System.out.println("Такого місяця не існує");
				}
				break;
			}

			case "2": {
				System.out.println("Введіть пору року: ");
				sc = new Scanner(System.in);
				String seasonSc = sc.next().toUpperCase();

				boolean flag = false;

				for (Month m : mas) {
					if (m.getSeasons().name().equals(seasonSc)) {
						flag = true;
					}
				}

				if (flag) {
					for (Month mon : mas) {
						if (mon.getSeasons().name().equals(seasonSc)) {
							System.out.println(mon);
						}
					}
				}
				if (!flag) {
					System.out.println("Такої пори року не існує");
				}
				break;
			}
			case "3":{
				System.out.println("Введіть кількість днів в місяці");
				sc = new Scanner(System.in);
				int monthDays = sc.nextInt();
				
				boolean flag = false;
				
				for (Month m : mas) {
					if (m.getDays() == monthDays) {
						flag = true;
					}
				}
				
				if(flag) {
					for (Month mon : mas) {
						if (mon.getDays() == monthDays) {
							System.out.println(mon);
						}
					}
				}
				if(!flag) {
					System.out.println("Місяця з такою кількостю днів не існує");
				}
				break;
			}
			case "4":{
				System.out.println("Введіть кількість днів в місяці");
				sc = new Scanner(System.in);
				int monthDays = sc.nextInt();
				
				boolean flag = false;
				
				for (Month m : mas) {
					if (m.getDays()<monthDays) {
						flag = true;
					}
				}
				
				if(flag) {
					for (Month mon : mas) {
						if(mon.getDays()<monthDays) {
							System.out.println(mon);
						}
					}
				}
				if(!flag) {
					System.out.println("Місяців з меншою кількостю днів не існує");
				}
				break;
			}
			case "5":{
				System.out.println("Введіть кількість днів в місяці");
				sc = new Scanner(System.in);
				int monthDays = sc.nextInt();
				
				boolean flag = false;
				
				for (Month m : mas) {
					if (m.getDays()>monthDays) {
						flag = true;
					}
				}
				
				if(flag) {
					for (Month mon : mas) {
						if(mon.getDays()>monthDays) {
							System.out.println(mon);
						}
					}
				}
				if(!flag) {
					System.out.println("Місяців з більшою кількостю днів не існує");
				}
				break;
			}
			case "6":{
				System.out.println("Введіть пору року: ");
				sc = new Scanner(System.in);
				String seasons = sc.next().toUpperCase();
				
				boolean flag = false;
				
				for (Seasons s: sea) {
					if(s.name().equals(seasons)) {
						flag = true;
					}
				}
				
				if (flag) {
					Seasons sea2 = Seasons.valueOf(seasons);
					int ordinal = sea2.ordinal();
					
					if (ordinal == (sea.length-1)) {
						ordinal = 0;
						System.out.println(sea[ordinal]);
					}else {
						System.out.println(sea[ordinal +1]);
					}
				}
				break;
			}
			case "7":{
				System.out.println("Введіть пору року: ");
				sc = new Scanner(System.in);
				String seasons = sc.next().toUpperCase();
				
				boolean flag = false;
				
				for (Seasons s: sea) {
					if(s.name().equals(seasons)) {
						flag = true;
					}
				}
				
				if (flag) {
					Seasons sea2 = Seasons.valueOf(seasons);
					int ordinal = sea2.ordinal();
					
					if (ordinal == 0) {
						ordinal = sea.length-1;
						System.out.println(sea[ordinal]);
					}else {
						System.out.println(sea[ordinal - 1]);
					}
				}
				break;
			}
			case "8":{
				for (Month mon : mas) {
					if(mon.getDays() % 2 == 0) {
						System.out.println("Місяці, які мають парну кількість днів: " + mon);
					}	
				}
				break;
			}
			case "9":{
				for (Month mon : mas) {
					if(mon.getDays() % 2 != 0) {
						System.out.println("Місяці, які мають непарну кількість днів: " + mon);
					}	
				}
				break;
			}
			case "10":{
				System.out.println("Введіть місяць: ");
				sc = new Scanner(System.in);
				String month = sc.next().toUpperCase();
				
				boolean flag = false;
				
				for (Month m : mas) {
					if (m.name().equals(month)) {
						flag = true;
					}
				}
				
				Month mon2 = Month.valueOf(month);
				
				
				if(flag) {
					if(mon2.getDays() % 2 == 0) {
						System.out.println("Даний місяць має парну кількість днів");
					}else {
						System.out.println("Даний місяць має непарну кількість днів");
					}
				}
				if(!flag) {
					System.out.println("Вказаного місяця не існує");
				}
			}
			}
		}
	}

	private static boolean isMonthPresent(Month[] mas, String month) {
		boolean flag = false;

		for (Month m : mas) {
			if (m.name().equals(month)) {
				System.out.println("Місяць існує");
				flag = true;
			}
		}
		return flag;
	}

}
