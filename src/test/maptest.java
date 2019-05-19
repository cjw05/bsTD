package test;

public class maptest {

	public static void main(String[] args) {

	int mun=0;	
	for(int e=0;e<37;e++){
		if(e%2==0){
			for(int w=0;w<5;w++){
				for(int q=0;q<37;q++){
					if(q%2==0){
						for(int i=0;i<5;i++){
							System.out.print("1");
							mun++;
						}
					}
					else{
						for(int j=0;j<5;j++){
							System.out.print("0");
							mun++;
						}
					}
					
				}
				System.out.println("");//»»ÐÐ
			}
		}
		else{
			for(int w=0;w<5;w++){
				for(int q=0;q<37;q++){
					if(q%2==0){
						for(int i=0;i<5;i++){
							System.out.print("0");
							mun++;
						}
					}
					else{
						for(int j=0;j<5;j++){
							System.out.print("1");
							mun++;
						}
					}
					
				}
				System.out.println("");//»»ÐÐ
			}
		}
	}
		
		
		
		
		
		System.out.println(mun);
		
		
		
		
	}
	
	
	
}
