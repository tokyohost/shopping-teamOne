//import java.text.DecimalFormat;

public class JDcircle_line {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		        Point[] r=new Point[2];	
		        //����ֱ�߷��̲���
		        Line line=new Line(1,-1,0);
		        System.out.println("22��"+(line.a)+" , "+(line.b)+" , "+(line.c));   
		    	
		        //����Բ��������뾶(�򳤶���)
		        Point center=new Point(0,0);
		       	Circlee circle= new Circlee(2,2,center);
				r=circle.CL_jd0new(circle,line);
				//DecimalFormat df=new DecimalFormat("#.00");
				for(int i=0;i<2;i++){
					System.out.println("������"+(r[i].x)+" , "+(r[i].y));   
			 		
					
				}
		

	}
}

class Circlee{
	Point[] r=new Point[2];   // �洢��������
    Point c;  // Բ��
    double rid,ridb;  //��Բ�ĳ�����
    
   
	Circlee(double rid,double ridb,Point c){
		this.c=new Point(c.x,c.y);
		this.rid=rid;
		this.ridb=ridb;
	}
	Point[] CL_jd0new(Circlee c,Line l){
		Point[] r={new Point(),new Point()};
		double tpai=2*3.14;
		int k=0;
		double delta;
		System.out.println("11��"+(c.rid)+" , "+(c.c.x));   
		System.out.println("11��"+(l.a)+" , "+(l.b)+" , "+(l.c));   
		
		for(double i=0;i<tpai;i=i+0.0001){
			double x=c.c.x+c.rid*Math.cos(i);
			double y=c.c.y+c.ridb*Math.sin(i);
			delta=l.a*x+l.b*y+l.c;
			if(Math.abs(delta)<0.001){
				r[k].x=x;r[k].y=y;i = i + 0.1;if(k++==2)break;
			}
			
		}
		for(int ii=0;ii<2;ii++){
			System.out.println("����11��"+(r[ii].x)+" , "+(r[ii].y));   
		}	
		return r;
		
	}
	
} 








