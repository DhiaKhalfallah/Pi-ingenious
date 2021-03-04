<?php

namespace App\Entity;

use App\Repository\UserRepository;
use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Security\Core\User\UserInterface;
use Symfony\Component\Validator\Constraints as Assert;
use Symfony\Bridge\Doctrine\Validator\Constraints\UniqueEntity;


/**
 * @ORM\Entity(repositoryClass=UserRepository::class)
 * *@ORM\InheritanceType("JOINED")
 * @ORM\DiscriminatorColumn(name="typeC", type="string")
 * @ORM\DiscriminatorMap({
 *       "candidate" = "Candidate",
 *       "entreprise" = "Entreprise",
 *       "admin" = "Admin"
 *     })
 * @UniqueEntity("email")
 */
abstract class User implements UserInterface, \Serializable
{
    /**
     * @ORM\Id
     * @ORM\GeneratedValue
     * @ORM\Column(type="integer" ,unique=true)
     */
    private $id;

    /**
     * @ORM\Column(type="string", length=255 , unique=true)
     * @Assert\Email(message = "The email '{{ value }}' is not a valid
    email.")
     */
    private $email;

    /**
     * @ORM\Column(type="string", length=255)

     */
    private $password;

    /**
     * @ORM\Column(type="boolean")
     */
    private $type;

    /**
     * @ORM\Column(type="json")
     */
    private $roles = [];

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getEmail(): ?string
    {
        return $this->email;
    }

    public function setEmail(string $email): self
    {
        $this->email = $email;

        return $this;
    }

    public function getPassword(): ?string
    {
        return $this->password;
    }

    public function setPassword(string $password): self
    {
        $this->password = $password;

        return $this;
    }

    public function getType(): ?bool
    {
        return $this->type;
    }

    public function setType(bool $type): self
    {
        $this->type = $type;

        return $this;
    }

    public function getRoles(): ?array
    {
        return [
            'ROLE_USER'
        ] ;
    }

    public function setRoles(array $roles): self
    {
        $this->roles = $roles;

        return $this;
    }
    public function getSalt()
    {
        // TODO: Implement getSalt() method.
    }
    public function eraseCredentials()
    {
        // TODO: Implement eraseCredentials() method.
    }
    public function getUsername()
    {
    return $this->id ;
    }
    public function serialize()
    {
        return serialize([
            $this->id,
            $this->email,
            $this->password,
            $this->type,
            $this->roles
        ]);
    }
    public function unserialize($string)
    {
     list (
         $this->id,
         $this->email,
         $this->password,
         $this->type,
         $this->roles
         ) = unserialize($string,['allowed_classes'=> false]);
    }

}
