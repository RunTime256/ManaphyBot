package discord.components.functionality.command;

public enum RoleRequirement
{
    VERIFIED("verified"),
    LICENSE("license"),
    MOD("mod"),
    ADMIN("admin"),
    MANAGER("manager");

    private String role;

    RoleRequirement(String role)
    {
        this.role = role;
    }

    public String getRole()
    {
        return this.role;
    }
}