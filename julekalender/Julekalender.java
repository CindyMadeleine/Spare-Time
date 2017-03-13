public class Julekalender{
	static ReadText rt = new ReadText();

	public static String opprettLuke(int dagidag) throws Exception{
		if(dagidag < 12){
			rt.initialize("PikenSomJulenissenIkkeKjente.txt");
		} else if(dagidag == 12){
			rt.initialize("julevitser.txt");
		} else if(dagidag == 24){
			rt.initialize("SnomannenKalle.txt");
		} else {
			rt.initialize("Grantreet.txt");
		}
		

		if(dagidag == 1)
			return luke1();
		else if(dagidag == 2)
			return luke2();
		else if(dagidag == 3)
			return luke3();
		else if(dagidag == 4)
			return luke4();
		else if(dagidag == 5)
			return luke5();
		else if(dagidag == 6)
			return luke6();
		else if(dagidag == 7)
			return luke7();
		else if(dagidag == 8)
			return luke8();
		else if(dagidag == 9)
			return luke9();
		else if(dagidag == 10)
			return luke10();
		else if(dagidag == 11)
			return luke11();
		else if(dagidag == 12)
			return luke12();
		else if(dagidag == 13)
			return luke13();
		else if(dagidag == 14)
			return luke14();
		else if(dagidag == 15)
			return luke15();
		else if(dagidag == 16)
			return luke16();
		else if(dagidag == 17)
			return luke17();
		else if(dagidag == 18)
			return luke18();
		else if(dagidag == 19)
			return luke19();
		else if(dagidag == 20)
			return luke20();
		else if(dagidag == 21)
			return luke21();
		else if(dagidag == 22)
			return luke22();
		else if(dagidag == 23)
			return luke23();
		else if(dagidag == 24)
			return luke24();

		return "God jul";
	}

	public static String luke1() throws Exception{
		return rt.les(0, 6);
	}

	public static String luke2() throws Exception{
		 return rt.les(6, 7);
	}

	public static String luke3() throws Exception{
		 return rt.les(7, 14);
	}

	public static String luke4() throws Exception{
		 return rt.les(14, 20);
	}

	public static String luke5() throws Exception{
		 return rt.les(20, 26);
	}

	public static String luke6() throws Exception{
		return rt.les(26, 36);
	}

	public static String luke7() throws Exception{
		return rt.les(36, 40);
	}

	public static String luke8() throws Exception{
		return rt.les(40, 45);
	}

	public static String luke9() throws Exception{
		return rt.les(45, 50);
	}

	public static String luke10() throws Exception{
		return rt.les(50, 54);
	}

	public static String luke11() throws Exception{
		return rt.les(54, 60);
	}

	public static String luke12() throws Exception{ //Må reguleres
		return rt.les(0,30);
	}

	public static String luke13() throws Exception{
		return rt.les(0, 5);
	}

	public static String luke14() throws Exception{
		return rt.les(5, 13);
	}

	public static String luke15() throws Exception{
		return rt.les(14, 20);
	}

	public static String luke16() throws Exception{
		return rt.les(20, 26);
	}

	public static String luke17() throws Exception{
		return rt.les(26, 31);
	}

	public static String luke18() throws Exception{
		return rt.les(31, 36);
	}

	public static String luke19() throws Exception{
		return rt.les(36, 40);
	}

	public static String luke20() throws Exception{
		return rt.les(40, 49);
	}

	public static String luke21() throws Exception{
		return rt.les(49, 56);
	}

	public static String luke22() throws Exception{
		return rt.les(56, 62);
	}

	public static String luke23() throws Exception{
		return rt.les(62, 70);
	}

	public static String luke24() throws Exception{
		return rt.les(0, 22);
	}
}