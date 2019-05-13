package email;


import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimePart;
import java.util.Base64;


public class Email {
    public static void main(String[] args) {
        try {

            EmailUtils emailUtils=new EmailUtils("sbhardwaj@j.mail","123123","jmail.cvent.com", EmailUtils.EmailFolder.INBOX);
            emailUtils.getNumberOfMessages();
            int getNumberOfUnreadMessages=emailUtils.getNumberOfUnreadMessages();
            System.out.print("Unread Messages::::"+getNumberOfUnreadMessages);
//            emailUtils.getAllMessages();

            //not really working
//            Message[] messagesBySubject=emailUtils.getMessagesBySubject("We've missed you%",true,50);
//            System.out.print(messagesBySubject.length);
//
//            Message message=emailUtils.getMessageByIndex(10);
//            String html= emailUtils.getMessageContent(message);
//            String subject=message.getSubject();
//            System.out.println("Subject::"+subject);
//            System.out.println("HTML::"+html);



//            boolean messageFound=emailUtils.isMessageInFolder("Hello",true);
//            System.out.println("found hello??::"+messageFound);

            Message latestMessage=emailUtils.getLatestMessage();
            String latestHtml= emailUtils.getMessageContent(latestMessage);
            if (MimeMultipart.class.isAssignableFrom(latestMessage.getContent().getClass())) {
                MimeMultipart mimeMultipart = (MimeMultipart) latestMessage.getContent();
                for (int i = 0; i < mimeMultipart.getCount(); i++) {
                    System.out.println("====>" + mimeMultipart.getBodyPart(i).getContent());
                }

            }
//            System.out.printf(String.valueOf(message.getHeader("Content-Transfer-Encoding")));
           // System.out.printf("decoded:" + Base64.getDecoder().decode(latestHtml));
            System.out.println("latestMessageContent::"+ ((MimeMultipart)latestMessage.getContent()));
            System.out.println("latestMessagehtml::"+latestHtml);
            String latestSubject=latestMessage.getSubject();


            int messageNumber=latestMessage.getMessageNumber();
            System.out.println("mnum:::"+messageNumber);
            String latestDate=latestMessage.getReceivedDate().toString();




            System.out.println("latestMessagesubject::"+latestSubject);
            //System.out.println("latestMessagecontent::"+latestCotent);
            System.out.println("latestMessagedate::"+latestDate);

        }catch (Exception e){
            System.out.print(e);
        }

    }
}