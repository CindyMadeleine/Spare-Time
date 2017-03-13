import javax.swing.JFrame;
import java.awt.Container;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.BorderLayout;
import java.util.Arrays;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.net.URL;
import java.net.MalformedURLException;

public class Juleramme extends JFrame {
	Container lerret;
	Julekalender jul;

	public Juleramme(int dagidag) throws Exception{
		setTitle("God jul");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200,1000); 

		lerret = getContentPane();
		lerret.setLayout(new BorderLayout());
		dagPanel(dagidag);

		setVisible(true);
	}

	private void dagPanel(int dagidag) throws Exception{
		final int JULAFTEN = 24;
		int daysToChristmas = JULAFTEN - dagidag;
	
		if(dagidag > JULAFTEN){
			JLabel label = new JLabel("Ha en riktig fin og fredelig romjul!");
			label.setFont(new Font("Serif", Font.PLAIN, 30));
			lerret.add(label, BorderLayout.CENTER);
			return;
		}


		JLabel label = new JLabel(dagidag + ". Desember. -" + daysToChristmas +  ". dager igjen til jul");
		label.setFont(new Font("Serif", Font.PLAIN, 30));
		lerret.add(label, BorderLayout.NORTH);
		
		julPanel(dagidag);
		juleBilde(dagidag);
	}

	private void julPanel(int dagidag) throws Exception {
		jul = new Julekalender();
		String historie = jul.opprettLuke(dagidag); //Må dele opp strengen på en eller annen måte?
		String[] output = historie.split(" "); //Deler historien opp på ord.

		JPanel panel = new JPanel();
		
		for(int i = 0; i < output.length; i++){ //Muligens litt ueffektivt, men man ser likevel all teksten!
			JLabel label1 = new JLabel(output[i]);
			label1.setFont(new Font("Serif", Font.PLAIN, 20));
			panel.add(label1, BorderLayout.EAST);
		}

		lerret.add(panel);
	}

	private void juleBilde(int dagidag) throws MalformedURLException{
		/*URL imageLocation = new URL(
			"http://www.redmix.info/images/jultomter/big/pere1.gif");

		URL imageLocation = new URL(
			"http://interiorhuset.sprayblogg.no/images/julehus_1163118302.gif");
	
		*/
		URL imageLocation = bilde_url(dagidag);
		

			ImageIcon mi = new ImageIcon(imageLocation);
		JLabel picLabel = new JLabel(mi);
		lerret.add(picLabel, BorderLayout.WEST);
	}

	private URL bilde_url(int dagidag) throws MalformedURLException{
		String bildeside = "";
		switch(dagidag){
			case 1: bildeside = "http://2.bp.blogspot.com/-rQXCTb_UXYE/TuzicsUOYBI/AAAAAAAAFqk/Ai7LWew79Z4/s1600/924136-8-1292087779596.jpg";
				break;
			case 2: bildeside = "http://dms07.dimu.org/image/042s7YYscPns?dimension=800x800";
				break;
			case 3: bildeside = "http://static2.melk.no/sitefiles/site6/files/artimg/julekaker-7-slag-til-jul12.jpg";
				break;
			case 4: bildeside = "http://www.julinorge.no/images/2a.jpg";
				break;
			case 5:	bildeside = "https://wiki.no.grepolis.com/images/f/f3/Jul.jpg";
				break;
			case 6: bildeside = "https://gardenofserendipity.files.wordpress.com/2012/12/73082_509674122388059_1710664658_n.png";	
				break;
			case 7: bildeside = "http://1.bp.blogspot.com/_KsWLvT1WWFM/TRX5ll8lUTI/AAAAAAAAAHA/1d48xT_PgKw/s1600/mrs6.gif";
				break;
			case 8:	bildeside = "http://www.mastervet.no/wp-content/uploads/2011/12/hundkattkanin.png";
				break;
			case 9: bildeside = "http://www.mastervet.no/wp-content/uploads/2011/12/hundkattkanin.png";//"http://2.bp.blogspot.com/_a4_L9xWsfz0/TRTY0kdZeaI/AAAAAAAAE3I/kFFeRAy-V2g/s1600/dc-universe-christmas-cute.jpg";
				break;
			case 10: bildeside = "http://hos-tina.dk/Animationer/Jul/juledyr/1016.gif";
				break;
			case 11: bildeside = "http://www.mommyish.com/wp-content/uploads/2015/11/santa-claus.jpg";
				break;
			case 12: bildeside = "https://rebeccaluellamiller.files.wordpress.com/2015/12/christmas-trees.jpg?w=300&h=178";
				break;
			case 13: bildeside = "https://s-media-cache-ak0.pinimg.com/236x/55/ae/6d/55ae6df129a69f0e9a87a7e7f87dc71a.jpg";
				break;
			case 14: bildeside = "http://www.clipartkid.com/images/100/christmas-clipart-cute-reindeer-scrapbooking-rudolph-red-nose-reindeer-ApqZ1V-clipart.jpg";
				break;
			case 15: bildeside = "https://thumbs.dreamstime.com/x/christmas-candy-cane-decorated-bow-holl-16569806.jpg";
				break;
			case 16: bildeside = "http://farm1.static.flickr.com/34/72968490_5d4f550e0e.jpg";
				break;
			case 17: bildeside = "https://referdia.files.wordpress.com/2013/11/elf.png";
				break;
			case 18: bildeside = "https://countryandvictoriantimes.files.wordpress.com/2014/12/10405424_838602956199213_7251348291463915835_n.jpg?w=350&h=200&crop=1";
				break;
			case 19: bildeside = "http://img2.thejournal.ie/inline/1206333/original/?width=500&version=1206333";//"http://cdn.history.com/sites/2/2015/04/hith-father-christmas-lights-iStock_000029514386Large.jpg";
				break;
			case 20: bildeside = "http://www.loren.no/wp/wp-content/uploads/2015/11/Juleverksted-AKS.jpg";
				break;
			case 21: bildeside = "http://crazy-frankenstein.com/free-wallpapers-files/old-christmas-wallpapers/kids-joy-old-christmas-wallpapers.jpg";
				break;
			case 22: bildeside = "http://sjiraffpaeventyr.net/wp-content/uploads/2011/12/disneyjul.jpg";
				break;
			case 23: bildeside = "http://az616578.vo.msecnd.net/files/2015/12/18/635860541466144826981586369_real-santa-claus.jpg";
				break;
			case 24: bildeside = "http://www.goodwp.com/large/201312/30502.jpg"; 
				break;
			default: bildeside = "http://www.online.no/Images/julmedYouTube620x350_tcm48-180964.jpg";
				break;
		}
		return new URL(bildeside);
	}
}