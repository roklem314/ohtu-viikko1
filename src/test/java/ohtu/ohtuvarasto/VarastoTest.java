package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    @Test
    public void laitetaanliikaaTavaraa(){
        varasto.lisaaVarastoon(10);
        varasto.lisaaVarastoon(1);
            assertEquals(10,varasto.getSaldo(),vertailuTarkkuus);
    }
    @Test
    public void otetaanLiikaaTavaraa(){
        varasto.lisaaVarastoon(10);
      
        assertEquals(10,varasto.otaVarastosta(11),vertailuTarkkuus);
    }
    @Test
    public void tyhjaanVarastoonEiVoiLisata(){
        Varasto tyhjavarasto = new Varasto(0);
        tyhjavarasto.lisaaVarastoon(10);
        assertEquals(0,tyhjavarasto.getSaldo(), vertailuTarkkuus);
    }
    @Test
    public void tyhjaanVarastoonEiVoiOttaaTavaraa(){
        Varasto tyhjavarasto = new Varasto(0);
        assertEquals(0,tyhjavarasto.otaVarastosta(10), vertailuTarkkuus);
    }
    @Test
    public void alustetaanVarastoSaldolla(){
        Varasto varasto2 = new Varasto(10,4);
        assertEquals(4,varasto2.getSaldo(),vertailuTarkkuus);
        assertEquals(10,varasto2.getTilavuus(), vertailuTarkkuus);
    }
    @Test
    public void lisaaNegatiivistaVarastoon(){
        varasto.lisaaVarastoon(-1);
        assertEquals(10,varasto.getTilavuus(), vertailuTarkkuus);
    }
    @Test
    public void varastoYritetaanAlustaaNegatiivisellaTilavuudella(){
        Varasto uusivarasto = new Varasto(-1);
        assertEquals(0,uusivarasto.getTilavuus(),vertailuTarkkuus);
    }
    @Test
    public void varastoYritetaanAlustaaNegatiivisellaTilavuudellaJaNegatiivisellaSaldolla(){
        Varasto uusivarasto = new Varasto(-1,-1);
        assertEquals(0,uusivarasto.getTilavuus(),vertailuTarkkuus);
        assertEquals(0,uusivarasto.getSaldo(), vertailuTarkkuus);
    }
    @Test
    public void varastoYritetaanAlustaaLiianSuurellaSaldolla(){
        Varasto uusivarasto = new Varasto(10,11);
        assertEquals(10,uusivarasto.getSaldo(), vertailuTarkkuus);
    }
    @Test
    public void varastostaYritetaanOttaaNegatiivista(){
        assertEquals(1,varasto.otaVarastosta(-100), vertailuTarkkuus);
    }
    @Test
    public void toStringTulostaaOikein(){
        assertEquals("saldo = "+ varasto.getSaldo()+", vielä tilaa "+ varasto.paljonkoMahtuu(), varasto.toString());
    }

}