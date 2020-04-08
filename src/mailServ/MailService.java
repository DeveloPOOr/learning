package mailServ;
import java.util.logging.Level;
import java.util.logging.Logger;



public interface MailService {
    Sendable processMail(Sendable mail);
}

/*
Класс, в котором скрыта логика настоящей почты
*/
class RealMailService implements MailService {

    @Override
    public Sendable processMail(Sendable mail) {
        // Здесь описан код настоящей системы отправки почты.
        return mail;
    }
}



interface Sendable {
    String getFrom();
    String getTo();
}
abstract class AbstractSendable implements Sendable {

    protected final String from;
    protected final String to;

    public AbstractSendable(String from, String to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public String getFrom() {
        return from;
    }

    @Override
    public String getTo() {
        return to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractSendable that = (AbstractSendable) o;

        if (!from.equals(that.from)) return false;
        if (!to.equals(that.to)) return false;

        return true;
    }

}

/*
Письмо, у которого есть текст, который можно получить с помощью метода `getMessage`
*/
class MailMessage extends AbstractSendable {

    private final String message;

    public MailMessage(String from, String to, String message) {
        super(from, to);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        MailMessage that = (MailMessage) o;

        if (message != null ? !message.equals(that.message) : that.message != null) return false;

        return true;
    }

}

/*
        Посылка, содержимое которой можно получить с помощью метода `getContent`
        */
class MailPackage extends AbstractSendable {
    private final Package content;

    public MailPackage(String from, String to, Package content) {
        super(from, to);
        this.content = content;
    }

    public Package getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        MailPackage that = (MailPackage) o;

        if (!content.equals(that.content)) return false;

        return true;
    }

}

/*
Класс, который задает посылку. У посылки есть текстовое описание содержимого и целочисленная ценность.
*/
 class Package {
    private final String content;
    private final int price;

    public Package(String content, int price) {
        this.content = content;
        this.price = price;
    }

    public String getContent() {
        return content;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Package aPackage = (Package) o;

        if (price != aPackage.price) return false;
        if (!content.equals(aPackage.content)) return false;

        return true;
    }
}


class UntrustworthyMailWorker implements MailService {
    MailService[] mails;
    RealMailService RealMailWorker = new RealMailService();
    public UntrustworthyMailWorker(MailService[] mails) {
        this.mails = mails;
    }
     @Override
    public Sendable processMail(Sendable mail) {
        Sendable prevResult = mails[0].processMail(mail);
        for(int i = 1; i < mails.length; i ++) {
            prevResult = mails[i].processMail(prevResult);
        }
        RealMailWorker.processMail(prevResult);
        return mail;
    }

    public RealMailService getRealMailWorker() {
        return RealMailWorker;
    }
}


class Spy implements MailService {
     Logger logger = null;
    public static final String AUSTIN_POWERS = "Austin Powers";
     public Spy (Logger logger) {
         this.logger = logger;
     }

    @Override
    public Sendable processMail(Sendable mail) {
         String from = mail.getFrom();
         String to = mail.getTo();


        if ( mail instanceof MailMessage ) {
            String message = ((MailMessage) mail).getMessage();
            if (from.equals(AUSTIN_POWERS) || to.equals(AUSTIN_POWERS)) {
                logger.log(Level.WARNING, "Detected target mail correspondence: from {0} to {1} \"{2}\"", new Object[] {
                    from,to,message});
            } else {
                logger.log(Level.INFO, "Usual correspondence: from {0} to {1}", new Object[] {from, to});
            }
        }
         return mail;
    }
}


class Thief implements MailService {
     int startPrice ;
     int total = 0;
     public Thief (int startPrice) {
         this.startPrice = startPrice;
     }

    @Override
    public Sendable processMail(Sendable mail) {
         if ( mail instanceof MailPackage) {

            Package content = ((MailPackage) mail).getContent();
            int price = content.getPrice();
            if ( price >= startPrice) {
                total += price;
                MailPackage stolenMail = new MailPackage(mail.getFrom(),mail.getTo(),new Package("stones instead of "+content.getContent(),  0));
                return stolenMail;
            }
        }

        return mail;
    }
    public int getStolenValue() {
        return total;
    }
}

class Inspector implements MailService {
    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";

    @Override
    public Sendable processMail(Sendable mail) {


        if (mail instanceof MailPackage) {
            String content = ((MailPackage) mail).getContent().getContent();
            if(content.contains(BANNED_SUBSTANCE) || content.contains(WEAPONS)) {
                throw new IllegalPackageException();
            } else {
                if (content.contains("stones")) {
                    throw new StolenPackageException();
                }
            }

        }
        return mail;
    }
}
class IllegalPackageException extends RuntimeException {
}


 class StolenPackageException extends RuntimeException {
}