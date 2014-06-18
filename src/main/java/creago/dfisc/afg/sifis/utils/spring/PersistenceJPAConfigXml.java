package creago.dfisc.afg.sifis.utils.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author creago
 */
@EnableTransactionManagement
@ComponentScan({"creago.dfisc.afg.sifis.planejamento"})
@ImportResource({"classpath:jpaConfig.xml"})
public class PersistenceJPAConfigXml {

    public PersistenceJPAConfigXml() {
        super();
    }
}
