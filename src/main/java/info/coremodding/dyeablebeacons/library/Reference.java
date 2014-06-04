/**
 * Copyright 2014 by CoreModding under GNU Lesser General Public License (LGPLv3)
 * http://www.gnu.org/licenses/gpl.html http://www.gnu.org/licenses/lgpl.html
 */
package info.coremodding.dyeablebeacons.library;

public class Reference {
  public class Mod {
    public static final String ID = "dyeablebeacons";
    public static final String NAME = "Dyeable Beacons";
    public static final String VERSION = "1.1.1";

    private Mod() {}
  }

  public class Proxy {
    public static final String CLIENT = "info.coremodding.dyeablebeacons.proxy.Client";
    public static final String SERVER = "info.coremodding.dyeablebeacons.proxy.Proxy";

    private Proxy() {}
  }

  private Reference() {}
}
