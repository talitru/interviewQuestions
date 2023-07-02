package il.co.ilrd.InterviewQuestions;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {


    public static int uniqueEmailCounter(String[] emails){

        int index;
        String domain, currStr;
        boolean plusFound = false;
        char currCh;
        StringBuilder newEmail = new StringBuilder();
        Set<String> emailsSet = new HashSet<String>();

        for(int i=0;i<emails.length; ++i){
            currStr = emails[i];
            System.out.println(currStr);
            newEmail = newEmail.replace(0,newEmail.length(),"");

            index = currStr.indexOf('@');
            domain = currStr.substring( index);
            System.out.println("domain: "+domain);
            plusFound = false;
            for(int j = 0; j<index&& !plusFound; ++j){
                currCh = currStr.charAt(j);
                if(currCh != '.' && currCh != '+'){
                    newEmail.append(currCh);
                }
                else if(currCh == '+'){
                    plusFound = true;
                }

            }
            System.out.println("newEmail - localname: "+newEmail.toString());
            newEmail.append(domain);
            System.out.println("newEmail: "+newEmail.toString());
            if(!emailsSet.contains(newEmail.toString())){
                emailsSet.add(newEmail.toString());
            }

        }
        return emailsSet.size();
    }


    public static void main(String[] args){

        String[] emails = {"tali.truneh+ name@gmail.com", "talitruneh@gmail.com", "tali+truenh@gmail.com"};
        System.out.println("num of unique emails: " +UniqueEmailAddresses.uniqueEmailCounter(emails));
    }
}
