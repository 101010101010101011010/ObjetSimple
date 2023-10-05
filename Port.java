public class Port {
    private PortType type;
    private PortDirectionality directionality;
    private Port connectedTo = null;

    Port(PortType _type, PortDirectionality _directionality) {
        this.type = _type;
        this.directionality = _directionality;
    }

    public PortType getType() {
        return this.type;
    }

    public PortDirectionality getDirectionality() {
        return this.directionality;
    }

    public Port getConnectedTo() {
        return this.connectedTo;
    }

    public boolean connect(Port targetPort) {
        if (!targetPort.type.equals(this.type)) { return false; }
        if (targetPort.directionality.equals(this.directionality)) { return false; }

        targetPort.disconnect(true);
        this.disconnect(true);

        this.connectedTo = targetPort;
        targetPort.connectedTo = this;

        return true;
    }

    /**
     * Deconnecte le port.
     * 
     * @param isRootCall  Indique si la methode a déjà appelée la méthode respective du port connecté
     */
    public void disconnect(Boolean isRootCall) {
        if (isRootCall && this.connectedTo != null) {
            this.connectedTo.disconnect(false);
        }

        this.connectedTo = null;
    }
    
    @Override
    public String toString() {
        return "This: " + String.valueOf(this.hashCode()) + "; Type: " + String.valueOf(this.type) + "; Directionality: " + String.valueOf(this.directionality) + "; Connected To: " + String.valueOf(this.connectedTo != null ? this.connectedTo.hashCode() : null);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) { return true; }
        if (!(obj instanceof Port)) { return false; }

        if (this.toString().equals(obj.toString())) { return true;}

        return false;
    }
}
