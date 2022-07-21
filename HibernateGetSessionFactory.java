    
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;


/**
 *
 * @author PC
 */
public class HibernateGetSessionFactory {

    private static final SessionFactory FACTORY;

    static {
        Configuration conf = new Configuration();
        Properties prop = new Properties();
        prop.put(Environment.DIALECT,"org.hibernate.dialect.SQLServerDialect");
        //ForMySQl 
        //prop.put(Environment.DIALECT,"org.hibernate.dialect.MySQLDialect");
        //
        prop.put(Environment.DRIVER,"com.microsoft.sqlserver.jdbc.SQLServerDriver");
        //ForMySQL
        //prop.put(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
        //
        prop.put(Environment.URL,"jdbc:sqlserver://PC\\SQLEXPRESS;database=hibernate1;encrypt=true;trustservercertificate=true;");
        //ForMySQL
        //prop.put(Environment.URL,"jdbc:mysql://localhost:3306/FPL_DAOTAO?autoReconnect=true&useSSL=false");
        prop.put(Environment.USER,"sa");
        prop.put(Environment.PASS,"1231234");
        conf.setProperties(prop);
        conf.addAnnotatedClass(?????.class);
        ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory(sr);
    }

    public static SessionFactory getSessionFactory() {
        return FACTORY;
    }
}