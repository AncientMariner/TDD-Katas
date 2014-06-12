package org.xander.katas;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class LeapYearTest {
    LeapYear leapYear;

    @Before
    public void setUp() {
        leapYear = new LeapYear();
    }

    @Test
    public void Basic() {
        assertNotNull(leapYear);
    }

    @Test
    public void notLeapYear1900() {
        assertFalse(leapYear.checkTheYear(1900));
    }

    @Test
    public void notLeapYear1999() {
        assertFalse(leapYear.checkTheYear(1999));
    }

    @Test
    public void notLeapYear2300() {
        assertFalse(leapYear.checkTheYear(2300));
    }

    @Test
    public void manyLeapYears() {
        assertTrue(leapYear.checkTheYear(1804));
        assertTrue(leapYear.checkTheYear(1808));
        assertTrue(leapYear.checkTheYear(1812));
        assertTrue(leapYear.checkTheYear(1816));
        assertTrue(leapYear.checkTheYear(1820));
        assertTrue(leapYear.checkTheYear(1824));
        assertTrue(leapYear.checkTheYear(1828));
        assertTrue(leapYear.checkTheYear(1832));
        assertTrue(leapYear.checkTheYear(1836));
        assertTrue(leapYear.checkTheYear(1840));
        assertTrue(leapYear.checkTheYear(1844));
        assertTrue(leapYear.checkTheYear(1848));
        assertTrue(leapYear.checkTheYear(1852));
        assertTrue(leapYear.checkTheYear(1856));
        assertTrue(leapYear.checkTheYear(1860));
        assertTrue(leapYear.checkTheYear(1864));
        assertTrue(leapYear.checkTheYear(1868));
        assertTrue(leapYear.checkTheYear(1872));
        assertTrue(leapYear.checkTheYear(1876));
        assertTrue(leapYear.checkTheYear(1880));
        assertTrue(leapYear.checkTheYear(1884));
        assertTrue(leapYear.checkTheYear(1888));
        assertTrue(leapYear.checkTheYear(1892));
        assertTrue(leapYear.checkTheYear(1896));
        assertTrue(leapYear.checkTheYear(1904));
        assertTrue(leapYear.checkTheYear(1908));
        assertTrue(leapYear.checkTheYear(1912));
        assertTrue(leapYear.checkTheYear(1916));
        assertTrue(leapYear.checkTheYear(1920));
        assertTrue(leapYear.checkTheYear(1924));
        assertTrue(leapYear.checkTheYear(1928));
        assertTrue(leapYear.checkTheYear(1932));
        assertTrue(leapYear.checkTheYear(1936));
        assertTrue(leapYear.checkTheYear(1940));
        assertTrue(leapYear.checkTheYear(1944));
        assertTrue(leapYear.checkTheYear(1948));
        assertTrue(leapYear.checkTheYear(1952));
        assertTrue(leapYear.checkTheYear(1956));
        assertTrue(leapYear.checkTheYear(1960));
        assertTrue(leapYear.checkTheYear(1964));
        assertTrue(leapYear.checkTheYear(1968));
        assertTrue(leapYear.checkTheYear(1972));
        assertTrue(leapYear.checkTheYear(1976));
        assertTrue(leapYear.checkTheYear(1980));
        assertTrue(leapYear.checkTheYear(1984));
        assertTrue(leapYear.checkTheYear(1988));
        assertTrue(leapYear.checkTheYear(1992));
        assertTrue(leapYear.checkTheYear(1996));
        assertTrue(leapYear.checkTheYear(2000));
        assertTrue(leapYear.checkTheYear(2004));
        assertTrue(leapYear.checkTheYear(2008));
        assertTrue(leapYear.checkTheYear(2012));
        assertTrue(leapYear.checkTheYear(2016));
        assertTrue(leapYear.checkTheYear(2020));
        assertTrue(leapYear.checkTheYear(2024));
        assertTrue(leapYear.checkTheYear(2028));
        assertTrue(leapYear.checkTheYear(2032));
        assertTrue(leapYear.checkTheYear(2036));
        assertTrue(leapYear.checkTheYear(2040));
        assertTrue(leapYear.checkTheYear(2044));
        assertTrue(leapYear.checkTheYear(2048));
        assertTrue(leapYear.checkTheYear(2052));
        assertTrue(leapYear.checkTheYear(2056));
        assertTrue(leapYear.checkTheYear(2060));
        assertTrue(leapYear.checkTheYear(2064));
        assertTrue(leapYear.checkTheYear(2068));
        assertTrue(leapYear.checkTheYear(2072));
        assertTrue(leapYear.checkTheYear(2076));
        assertTrue(leapYear.checkTheYear(2080));
        assertTrue(leapYear.checkTheYear(2084));
        assertTrue(leapYear.checkTheYear(2088));
        assertTrue(leapYear.checkTheYear(2092));
        assertTrue(leapYear.checkTheYear(2096));
        assertTrue(leapYear.checkTheYear(2104));
        assertTrue(leapYear.checkTheYear(2108));
        assertTrue(leapYear.checkTheYear(2112));
        assertTrue(leapYear.checkTheYear(2116));
        assertTrue(leapYear.checkTheYear(2120));
        assertTrue(leapYear.checkTheYear(2124));
        assertTrue(leapYear.checkTheYear(2128));
        assertTrue(leapYear.checkTheYear(2132));
        assertTrue(leapYear.checkTheYear(2136));
        assertTrue(leapYear.checkTheYear(2140));
        assertTrue(leapYear.checkTheYear(2144));
        assertTrue(leapYear.checkTheYear(2148));
        assertTrue(leapYear.checkTheYear(2152));
        assertTrue(leapYear.checkTheYear(2156));
        assertTrue(leapYear.checkTheYear(2160));
        assertTrue(leapYear.checkTheYear(2164));
        assertTrue(leapYear.checkTheYear(2168));
        assertTrue(leapYear.checkTheYear(2172));
        assertTrue(leapYear.checkTheYear(2176));
        assertTrue(leapYear.checkTheYear(2180));
        assertTrue(leapYear.checkTheYear(2184));
        assertTrue(leapYear.checkTheYear(2188));
        assertTrue(leapYear.checkTheYear(2192));
        assertTrue(leapYear.checkTheYear(2196));
        assertTrue(leapYear.checkTheYear(2204));
        assertTrue(leapYear.checkTheYear(2208));
        assertTrue(leapYear.checkTheYear(2212));
        assertTrue(leapYear.checkTheYear(2216));
        assertTrue(leapYear.checkTheYear(2220));
        assertTrue(leapYear.checkTheYear(2224));
        assertTrue(leapYear.checkTheYear(2228));
        assertTrue(leapYear.checkTheYear(2232));
        assertTrue(leapYear.checkTheYear(2236));
        assertTrue(leapYear.checkTheYear(2240));
        assertTrue(leapYear.checkTheYear(2244));
        assertTrue(leapYear.checkTheYear(2248));
        assertTrue(leapYear.checkTheYear(2252));
        assertTrue(leapYear.checkTheYear(2256));
        assertTrue(leapYear.checkTheYear(2260));
        assertTrue(leapYear.checkTheYear(2264));
        assertTrue(leapYear.checkTheYear(2268));
        assertTrue(leapYear.checkTheYear(2272));
        assertTrue(leapYear.checkTheYear(2276));
        assertTrue(leapYear.checkTheYear(2280));
        assertTrue(leapYear.checkTheYear(2284));
        assertTrue(leapYear.checkTheYear(2288));
        assertTrue(leapYear.checkTheYear(2292));
        assertTrue(leapYear.checkTheYear(2304));
        assertTrue(leapYear.checkTheYear(2308));
        assertTrue(leapYear.checkTheYear(2312));
        assertTrue(leapYear.checkTheYear(2316));
        assertTrue(leapYear.checkTheYear(2320));
        assertTrue(leapYear.checkTheYear(2324));
        assertTrue(leapYear.checkTheYear(2328));
        assertTrue(leapYear.checkTheYear(2332));
        assertTrue(leapYear.checkTheYear(2336));
        assertTrue(leapYear.checkTheYear(2340));
        assertTrue(leapYear.checkTheYear(2344));
        assertTrue(leapYear.checkTheYear(2348));
        assertTrue(leapYear.checkTheYear(2352));
        assertTrue(leapYear.checkTheYear(2356));
        assertTrue(leapYear.checkTheYear(2360));
        assertTrue(leapYear.checkTheYear(2364));
        assertTrue(leapYear.checkTheYear(2368));
        assertTrue(leapYear.checkTheYear(2372));
        assertTrue(leapYear.checkTheYear(2376));
        assertTrue(leapYear.checkTheYear(2380));
        assertTrue(leapYear.checkTheYear(2384));
        assertTrue(leapYear.checkTheYear(2388));
        assertTrue(leapYear.checkTheYear(2392));
        assertTrue(leapYear.checkTheYear(2396));
        assertTrue(leapYear.checkTheYear(2400));
    }
}


