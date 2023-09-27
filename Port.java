public class Port {
    private PortType type;
    private PortDirectionality directionality;
    private Port connectedTo = null;

    Port(PortType _type, PortDirectionality _directionality) {
        this.type = _type;
        this.directionality = _directionality;
    }

    public boolean Connect(Port targetPort) {
        if (!targetPort.type.equals(this.type)) { return false; }
        if (targetPort.directionality.equals(this.directionality)) { return false; }

        targetPort.Disconnect(true);
        this.Disconnect(true);

        this.connectedTo = targetPort;
        targetPort.connectedTo = this;

        return true;
    }

    /**
     * Deconnecte le port.
     * 
     * @param isRootCall  Indique si la methode a deja appelee la methode respective du port connecte
     */
    public void Disconnect(Boolean isRootCall) {
        if (isRootCall && this.connectedTo != null) {
            this.connectedTo.Disconnect(false);
        }

        this.connectedTo = null;
    }
    
    public String ToString() {
        return "This: " + String.valueOf(this) + "; Type: " + String.valueOf(this.type) + "; Directionality: " + String.valueOf(this.directionality) + "; Connected To: " + String.valueOf(this.connectedTo);
    }
}
